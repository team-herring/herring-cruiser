package org.herring.worker.server;


import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.worker.container.WorkServiceManager;
import org.herring.cruiser.core.service.WorkerService;

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
        if (request.getCommand() == 1) {
            WorkerService workerService = WorkServiceManager.findAndCreate(request);
            NextWorker nextWorker = HerringDataSenderFactory.create(request);
            workerService.service(request, response, nextWorker);
        }


        response.close();
    }
}
