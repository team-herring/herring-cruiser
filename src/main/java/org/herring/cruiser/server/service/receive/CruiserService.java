package org.herring.cruiser.server.service.receive;

import org.herring.cruiser.server.request.next.Next;
import org.herring.cruiser.server.request.Request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiserService {
    public void service(Request request, Next next);
}
