package org.herring.cruiser.core.service.work;

import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.core.service.WorkerService;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public abstract class Work implements WorkerService {
    @Override
    public void service(Request request, Response response, NextWorker nextWorker) {
        working(request, nextWorker);
    }

    public abstract void working(Request request, NextWorker nextWorker);
}
