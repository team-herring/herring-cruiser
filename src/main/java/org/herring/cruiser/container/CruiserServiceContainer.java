package org.herring.cruiser.container;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.server.service.CruiserService;
import org.herring.cruiser.server.service.worker.WorkerFindService;
import org.herring.cruiser.server.service.worker.WorkerReturnService;

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
        cruiserService.put("WorkerFindService", new WorkerFindService());
        cruiserService.put("WorkerReturnService", new WorkerReturnService());
    }

    public static CruiserService findCruiseService(Request request){
        JobCommand command = (JobCommand) request.getData();
        return cruiserService.get(command.getServiceName());
    }
}

