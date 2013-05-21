package org.herring.cruiser.service.next;

import org.herring.cruiser.container.CruiserServiceContainer;
import org.herring.cruiser.service.CruiserService;
import org.herring.cruiser.service.request.Request;
import org.herring.cruiser.service.request.analysis.RequestNext;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Next {
    public void nextService(Request request, int command, ByteBuffer buffer) throws Exception {
        RequestNext requestNext = new RequestNext(request, command, buffer);
        CruiserService cruiserService = CruiserServiceContainer.findCruiseService(requestNext);
        cruiserService.service(requestNext);
    }
}
