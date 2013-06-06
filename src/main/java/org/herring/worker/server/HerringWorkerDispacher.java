package org.herring.worker.server;


import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.worker.container.WorkerContainer;
import org.herring.worker.server.service.WorkerService;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringWorkerDispacher implements Runnable {
    private final Request request;
    private final Response response;

    public HerringWorkerDispacher(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() {
        NextWorker nextWorker = HerringDataSenderFactory.create(request);
        WorkerService workerService = WorkerContainer.findService(request);
        workerService.service(request, response, nextWorker);
        response.close();
    }
}
