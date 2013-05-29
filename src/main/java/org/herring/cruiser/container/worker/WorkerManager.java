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
    private static Map<String, Worker> workerMap;

    static {
        workerMap = new ConcurrentHashMap<String, Worker>();
        workerMap.put("test", new Worker("localhost", 8855));
    }

    public static void regist(String name, Worker cruiserSerivce){
        workerMap.put(name, cruiserSerivce);
    }

    public static Worker find(String name){
        return workerMap.get(name);
    }

    public static Worker get(){
        return workerMap.get("test");
    }
}
