package org.herring.cruiser.server.service;


import org.herring.cruiser.container.CruiserServiceContainer;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserDispacher implements Runnable {
    private final Request request;
    private final Response response;

    public HerringCruiserDispacher(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() {
        CruiserService cruiserService = CruiserServiceContainer.findCruiseService(request);
        try {
            cruiserService.service(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.close();
    }
}
