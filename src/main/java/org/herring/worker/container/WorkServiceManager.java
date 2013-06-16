package org.herring.worker.container;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.service.WorkerService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkServiceManager {
    private static Map<JobCommand, WorkerService> workerServiceMap;

    static {
        workerServiceMap = new ConcurrentHashMap<JobCommand, WorkerService>();
    }

    public static WorkerService findAndCreate(Request request) {
        JobCommand jobCommand = (JobCommand) request.getData();
        assert (jobCommand != null);

        if (workerServiceMap.containsKey(jobCommand))
            return workerServiceMap.get(jobCommand);

        WorkerService workerService = WorkerServiceFactory.create(jobCommand);
        if (workerService == null)
            throw new RuntimeException("does not create WorkerService");

        workerServiceMap.put(jobCommand, workerService);
        return workerService;
    }

    public static void remove(Request request){
        JobCommand jobCommand = (JobCommand) request.getData();
        workerServiceMap.remove(jobCommand);
    }
}
