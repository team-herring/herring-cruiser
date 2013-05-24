package org.herring.cruiser.navigation;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class NavigationManager {
    private static Map<String, Navigation> navigationMap;

    static {
        navigationMap = new HashMap<String, Navigation>();
    }

    public static void regist(String name, Navigation navigation){
        navigationMap.put(name, navigation);
    }

    public static Navigation find(String name){
        return navigationMap.get(name);
    }
}
