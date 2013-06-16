package org.herring.cruiser.core.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerServiceCommand {
    private static Map<String, Integer> workerService;

     static {
         workerService = new ConcurrentHashMap<String, Integer>();
         workerService.put("indexCreate", 1);
     }

    public static Integer get(String serviceName){
        return workerService.get(serviceName);
    }
}
