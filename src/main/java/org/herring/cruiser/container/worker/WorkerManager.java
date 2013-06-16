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
        workerMap.put("localhost", new Worker("localhost", 8855));
        workerMap.put("localhost2", new Worker("localhost2", 8856));
        workerMap.put("localhost2", new Worker("localhost2", 8857));
    }

    public static void regist(String name, Worker cruiserSerivce){
        workerMap.put(name, cruiserSerivce);
    }

    public static Worker find(String name){
        return workerMap.get(name);
    }

    public static Worker get(){
        Worker worker = workerMap.get("localhost");
        worker.increase();
        return worker;
    }

    public static void remove(String ip) {
        Worker worker = workerMap.get(ip);
        worker.decrease();
    }
}
