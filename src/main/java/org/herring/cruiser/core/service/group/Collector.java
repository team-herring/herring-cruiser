package org.herring.cruiser.core.service.group;

import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.core.service.WorkerService;
import org.herring.worker.container.WorkServiceManager;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public abstract class Collector implements WorkerService {
    @Override
    public void service(Request request, Response response, NextWorker nextWorker) {
        service(request, nextWorker);
        WorkServiceManager.remove(request);
    }

    public abstract void service(Request request, NextWorker nextWorker);
}
