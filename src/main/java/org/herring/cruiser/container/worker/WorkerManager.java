package org.herring.cruiser.container.worker;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerManager {
    private static Map<String, Worker> navigationMap;

    static {
        navigationMap = new HashMap<String, Worker>();
    }

    public static void regist(String name, Worker worker){
        navigationMap.put(name, worker);
    }

    public static Worker find(String name){
        return navigationMap.get(name);
    }
}
