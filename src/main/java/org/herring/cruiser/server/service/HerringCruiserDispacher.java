package org.herring.cruiser.server.service;


import org.herring.cruiser.container.CruiserServiceContainer;
import org.herring.cruiser.server.service.receive.CruiserService;
import org.herring.cruiser.server.request.next.Next;
import org.herring.cruiser.server.request.Request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserDispacher implements Runnable {
    private final Next next;
    private final Request request;

    public HerringCruiserDispacher(Request request) {
        this.request = request;
        this.next = new Next();
    }

    @Override
    public void run() {
        CruiserService cruiserService = CruiserServiceContainer.findCruiseService(request);
        cruiserService.service(request, next);
    }
}
