package org.herring.cruiser.container.worker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerManager {
    private static Map<String, Worker> navigationMap;

    static {
        navigationMap = new ConcurrentHashMap<String, Worker>();
        navigationMap.put("test", new Worker("localhost", 8855));
    }

    public static void regist(String name, Worker cruiserSerivce){
        navigationMap.put(name, cruiserSerivce);
    }

    public static Worker find(String name){
        return navigationMap.get(name);
    }

    public static Worker get(){
        return navigationMap.get("test");
    }
}
