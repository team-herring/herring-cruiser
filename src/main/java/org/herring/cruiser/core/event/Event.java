package org.herring.cruiser.core.event;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Event {
    private static Map<String, EventHandler> container;

    static {
        container = new HashMap<String, EventHandler>();
    }

    public static Object find(String name){
       return container.get(name);
    }

    public static void put(String name, EventHandler eventHandler){
        container.put(name, eventHandler);
    }

    public static void remove(String name){

    }
}
