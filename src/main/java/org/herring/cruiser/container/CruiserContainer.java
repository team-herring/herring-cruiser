package org.herring.cruiser.container;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CruiserContainer implements Serializable {
    private static Map<String, Object> container;

    static {
        container = new HashMap<String, Object>();
    }


    public static Object find(String key){
       return container.get(key);
    }

    public static void put(String key, Object val){
        container.put(key, val);
    }
}
