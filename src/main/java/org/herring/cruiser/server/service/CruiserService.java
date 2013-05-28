package org.herring.cruiser.server.service;

import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiserService {
    public void service(Request request, Response response);
}
