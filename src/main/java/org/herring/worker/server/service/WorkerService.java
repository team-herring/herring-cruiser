package org.herring.worker.server.service;

import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface WorkerService {
    public void service(Request request, Response response, NextWorker nextWorker);
}
