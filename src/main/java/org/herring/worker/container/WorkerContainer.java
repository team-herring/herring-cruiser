package org.herring.worker.container;

import org.herring.cruiser.core.request.Request;
import org.herring.worker.server.service.RegistJobWorker;
import org.herring.worker.server.service.WorkerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerContainer {
    private static Map<String, WorkerService> workerService;

    static {
        workerService = new HashMap<String, WorkerService>();
        workerService.put("RegistJobWorker", new RegistJobWorker());
    }

    public static WorkerService findService(Request request){
        return workerService.get(request.getCommand());
    }
}
