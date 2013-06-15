package org.herring.cruiser.server.service.worker;

import org.herring.cruiser.container.worker.Worker;
import org.herring.cruiser.container.worker.WorkerManager;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.server.service.CruiserService;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerFindService implements CruiserService {
    @Override
    public void service(Request request, Response response) throws IOException {
        Worker worker = WorkerManager.get();
        response.sendObject(worker.getIp()+":"+worker.getPort());
    }
}
