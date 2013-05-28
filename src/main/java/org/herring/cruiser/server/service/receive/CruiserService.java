package org.herring.cruiser.server.service.receive;

import org.herring.cruiser.server.request.Request;
import org.herring.protocol.NetworkContext;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiserService {
    public void service(NetworkContext context, Request request);
}
