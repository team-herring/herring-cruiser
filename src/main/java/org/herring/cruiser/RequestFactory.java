package org.herring.cruiser;

import org.herring.cruiser.service.request.Request;
import org.herring.cruiser.service.request.ByteArrayRequest;

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
