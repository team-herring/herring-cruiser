package org.herring.cruiser.server.service;


import org.herring.cruiser.container.CruiserServiceContainer;
import org.herring.cruiser.server.request.Request;
import org.herring.protocol.NetworkContext;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserDispacher implements Runnable {
    private final Request request;
    private final NetworkContext context;

    public HerringCruiserDispacher(NetworkContext context, Request request) {
        this.request = request;
        this.context = context;
    }

    @Override
    public void run() {
        CruiserService cruiserService = CruiserServiceContainer.findCruiseService(request);
        cruiserService.service(context, request);
    }
}
