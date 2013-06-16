package org.herring.cruiser.job;

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
import org.herring.protocol.NetworkContext;

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

    public void start(int jobID) {
        if (collector != null) {
            ZooKeeperManager.createFolder(jobID + ZooKeeperManager.TOPOLOGY_DIRECTORY + "/collector/" + collector.getClass().getName());
            ZooKeeperManager.createFolder(jobID + ZooKeeperManager.EVENT_DIRECTORY + "/collector/" + collector.getClass().getName());
        }
        if (works != null) {
            for (Work work : works) {
                ZooKeeperManager.createFolder(jobID + ZooKeeperManager.TOPOLOGY_DIRECTORY + "/work/" + work.getClass().getName());
                ZooKeeperManager.createFolder(jobID + ZooKeeperManager.EVENT_DIRECTORY + "/work/" + work.getClass().getName());
            }
        }
        if (aggregation != null) {
            ZooKeeperManager.createFolder(jobID + ZooKeeperManager.TOPOLOGY_DIRECTORY + "/aggregation/" + aggregation.getClass().getName());
            ZooKeeperManager.createFolder(jobID + ZooKeeperManager.EVENT_DIRECTORY + "/aggregation/" + aggregation.getClass().getName());
        }

        if (collector != null) {
            sendServer(jobID, name, collector);
            return;
        }

        if (works != null) {
            for (Work work : works) {
                sendServer(jobID, name, work);
            }
            return;
        }

        if (aggregation != null) {
            sendServer(jobID, name, aggregation);
        }
    }

    public void sendServer(int jobID, String groupName, WorkerService service) {
        Worker worker = WorkerManager.get();
        MessageSender sender = new MessageSender(worker.getIp(), worker.getPort());
        JobCommand jobCommand = new JobCommand(jobID, groupName, service.getClass().getName());
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
