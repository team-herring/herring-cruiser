package org.herring.cruiser.server;

import org.herring.cruiser.server.request.Request;
import org.herring.cruiser.server.request.ByteArrayRequest;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class RequestFactory {
    public static Request getRequest(byte[] bytes) {
        return new ByteArrayRequest(bytes);
    }
}
