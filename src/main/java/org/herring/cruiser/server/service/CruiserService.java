package org.herring.cruiser.server.service;

import org.herring.cruiser.server.request.Request;
import org.herring.cruiser.server.response.Response;
import org.herring.protocol.NetworkContext;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiserService {
    public void service(Request request, Response response);
}
