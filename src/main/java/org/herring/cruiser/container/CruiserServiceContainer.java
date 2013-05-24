package org.herring.cruiser.container;

import org.herring.cruiser.server.service.receive.CruiserService;
import org.herring.cruiser.server.request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CruiserServiceContainer {
    private static List<CruiserService> list;

    static {
        list = new ArrayList<CruiserService>();
    }

    public static CruiserService findCruiseService(Request request){
        return list.get(request.getCommand());
    }
}
