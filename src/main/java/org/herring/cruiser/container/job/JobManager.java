package org.herring.cruiser.container.job;

import org.herring.cruiser.core.model.JobCommand;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobManager {
    private static Map<String, JobCommand> jobCommandMap;

    static {
        jobCommandMap = new ConcurrentHashMap<String, JobCommand>();
    }

    public static JobCommand createAndRegist(String command) {
        String uuid = createUUID();
        JobCommand jobCommand = new JobCommand(uuid, command);
        jobCommandMap.put(uuid, jobCommand);
        return jobCommand;
    }

    public static JobCommand find(String uuid){
        return jobCommandMap.get(uuid);
    }

    public void remove(String uuid){
        jobCommandMap.remove(uuid);
    }

    private static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
