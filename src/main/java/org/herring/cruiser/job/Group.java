package org.herring.cruiser.job;

import org.apache.zookeeper.KeeperException;
import org.herring.core.protocol.NetworkContext;
import org.herring.cruiser.container.worker.Worker;
import org.herring.cruiser.container.worker.WorkerManager;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.MessageSender;
import org.herring.cruiser.core.service.WorkerService;
import org.herring.cruiser.core.service.aggregate.Aggregation;
import org.herring.cruiser.core.service.group.Collector;
import org.herring.cruiser.core.service.work.Work;
import org.herring.cruiser.core.zookeeper.ZooKeeperManager;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Group implements Serializable {
    private String name;
    private String input;
    private String output;
    private String field;
    private List<Work> works;
    private Collector collector;
    private Aggregation aggregation;

    public Group(String name) {
        this.name = name;
    }

    public void group(Collector collector) {
        this.collector = collector;
    }

    public void input(String name) {
        this.input = name;
    }

    public void output(String name) {
        this.output = name;
    }

    public void addWork(Work work) {
        if (works == null)
            this.works = new ArrayList<Work>();
        this.works.add(work);
    }

    public void aggregation(Aggregation aggregation) {
        this.aggregation = aggregation;
    }

    public void deploy(int jobID) throws KeeperException {
        ZooKeeperManager.createGroupDirectory(jobID, name);
        if (collector != null)
            ZooKeeperManager.createCollector(jobID, name, collector.getClass().getSimpleName());

        if (works != null)
            for (Work work : works)
                ZooKeeperManager.createWork(jobID, name, work.getClass().getSimpleName());


        if (aggregation != null)
            ZooKeeperManager.createAggregation(jobID, name, aggregation.getClass().getSimpleName());


        if (input != null)
            ZooKeeperManager.createInformationFile(jobID, name, "input", input);

        if (output != null)
            ZooKeeperManager.createInformationFile(jobID, name, "output", output);

        if (collector != null) {
            ZooKeeperManager.createInformationFile(jobID, name, "server", "collector");
            return;
        }

        if (works != null) {
            ZooKeeperManager.createInformationFile(jobID, name, "server", "work");
            return;
        }

        ZooKeeperManager.createInformationFile(jobID, name, "server", "aggregation");
    }

    public void start(int jobID) {
        if (input == null && works != null) {
            for (Work work : works) {
                sendServer(jobID, name, work);
            }
        }
    }

    public void sendServer(int jobID, String groupName, WorkerService service) {
        Worker worker = WorkerManager.get();
        MessageSender sender = new MessageSender(worker.getIp(), worker.getPort());
        JobCommand jobCommand = new JobCommand(jobID, groupName, service.getClass().getName());

        jobCommand.setInputGroupID(input);
        jobCommand.setOutputGroupID(output);

        try {
            sender.sendJobCommand(jobCommand, new EventHandler() {
                @Override
                public void handler(NetworkContext context, Object o) {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


}
