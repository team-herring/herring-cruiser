package org.herring.worker.container;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.request.Request;

import java.util.Map;
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

    public static void regist(JobCommand jobCommand) {
        jobCommandMap.put(jobCommand.getJobId(), jobCommand);
    }

    public static JobCommand find(Request request) {
        if (jobCommandMap.containsKey(request.getJobID()))
            return jobCommandMap.get(request.getJobID());
        return (JobCommand) request.getData();
    }

    public static void remove(Request request){
        jobCommandMap.remove(request.getJobID());
    }
    public static void remove(JobCommand jobCommand) {
        jobCommandMap.remove(jobCommand.getJobId());
    }

    public static void remove(String uuid) {
        jobCommandMap.remove(uuid);
    }
}
