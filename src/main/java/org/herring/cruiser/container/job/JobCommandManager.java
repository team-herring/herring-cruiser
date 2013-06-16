package org.herring.cruiser.container.job;

import org.herring.cruiser.core.model.JobCommand;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobCommandManager {
    private static Map<Integer, JobCommand> jobCommandMap;

    static {
        jobCommandMap = new ConcurrentHashMap<Integer, JobCommand>();
    }

    public static JobCommand createAndRegist(Integer serviceCommand) {
        return null;
    }

    public static void remove(int id) {
        jobCommandMap.remove(id);
    }

    public static JobCommand find(int id) {
        return jobCommandMap.get(id);
    }
}
