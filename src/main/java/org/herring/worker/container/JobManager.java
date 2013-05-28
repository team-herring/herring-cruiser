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

    public static void regist(String uuid, JobCommand jobCommand){
        jobCommandMap.put(uuid, jobCommand);
    }

    public static JobCommand find(Request request){
        return jobCommandMap.get(request.getJobID());
    }
}
