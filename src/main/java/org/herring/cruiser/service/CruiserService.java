package org.herring.cruiser.service;

import org.herring.cruiser.service.next.Next;
import org.herring.cruiser.service.request.Request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiserService {
    public void service(Request request, Next next);
}
