package org.herring.cruiser.container;

import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.server.service.CruiserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CruiserServiceContainer {
    private static Map<String, CruiserService> cruiserService;

    static {
        cruiserService = new HashMap<String, CruiserService>();
    }

    public static CruiserService findCruiseService(Request request){
        return cruiserService.get(request.getCommand());
    }
}
