package org.herring.worker.container;

import org.apache.log4j.Logger;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.service.WorkerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerServiceFactory {
    private static final Logger log = Logger.getLogger(WorkerServiceFactory.class);
    private static Map<Integer, String> workerService;

    static {
        workerService = new HashMap<Integer, String>();
        workerService.put(1, "org.herring.worker.server.service.imple.RegistJobWorker");
    }

    public static WorkerService create(Request request) {
        String className = workerService.get(request.getCommand());
        try {
            return (WorkerService) Class.forName(className).newInstance();
        } catch (Exception ignored){
            log.error(ignored.getStackTrace());
        }
        return null;
    }
}
