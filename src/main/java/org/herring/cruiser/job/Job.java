package org.herring.cruiser.job;

import org.herring.cruiser.container.sequence.JobSequence;
import org.herring.cruiser.core.zookeeper.ZooKeeperManager;

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
    }

    public void append(Group group) {
        this.groups.add(group);
    }

    public void start(){
        for (Group group : groups) {
            ZooKeeperManager.registGroup(jobID, group);
            ZooKeeperManager.createFolder(jobID+ZooKeeperManager.TOPOLOGY_DIRECTORY);
            ZooKeeperManager.createFolder(jobID+ZooKeeperManager.EVENT_DIRECTORY);
        }

        for (Group group : groups) {
            group.start(jobID);
        }
    }
}
