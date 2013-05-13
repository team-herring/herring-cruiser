package org.herring.cruiser.service;

import org.herring.cruiser.service.request.Response;
import org.herring.cruiser.service.request.analysis.Request;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface CruiseService {
    public void service(Request request, Response response) throws IOException;
}
