package org.herring.cruiser.job;

import org.apache.zookeeper.KeeperException;
import org.herring.cruiser.container.sequence.JobSequence;
import org.herring.cruiser.core.zookeeper.ZooKeeperManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Job {
    private int jobID;
    private List<Group> groups;

    public Job() {
        this.jobID = JobSequence.get();
        this.groups = new ArrayList<Group>();
    }

    public void append(Group group) {
        this.groups.add(group);
    }

    public void start() {
        try {
            ZooKeeperManager.createJob(jobID);
            ZooKeeperManager.createTopologyDirectory(jobID);
            ZooKeeperManager.createEventDirectory(jobID);

            for (Group group : groups) {
                group.deploy(jobID);
            }

            for (Group group : groups) {
//                group.start(jobID);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
            deleteJobDirectory();
        }
    }

    private void deleteJobDirectory() {
        try {
            ZooKeeperManager.deleteDirectory(jobID);
        } catch (KeeperException e1) {
            e1.printStackTrace();
        }
    }
}
