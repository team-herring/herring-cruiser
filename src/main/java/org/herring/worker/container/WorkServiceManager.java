package org.herring.worker.container;

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
    private static Map<Request, WorkerService> workerServiceMap;

    static {
        workerServiceMap = new ConcurrentHashMap<Request, WorkerService>();
    }

    public static WorkerService findAndCreate(Request request) {
        if (workerServiceMap.containsKey(request))
            return workerServiceMap.get(request);
        WorkerService workerService = WorkerServiceFactory.create(request);
        workerServiceMap.put(request, workerService);
        return workerService;
    }

    public static void remove(Request request){
        workerServiceMap.remove(request);
    }
}
