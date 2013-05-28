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
    private static Map<String, CruiserSerivce> navigationMap;

    static {
        navigationMap = new HashMap<String, CruiserSerivce>();
    }

    public static void regist(String name, CruiserSerivce cruiserSerivce){
        navigationMap.put(name, cruiserSerivce);
    }

    public static CruiserSerivce find(String name){
        return navigationMap.get(name);
    }

    public static CruiserSerivce get(){
        return navigationMap.get("basic");
    }
}
