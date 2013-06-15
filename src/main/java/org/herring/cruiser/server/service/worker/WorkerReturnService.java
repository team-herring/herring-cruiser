package org.herring.cruiser.server.service.worker;

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
public class WorkerReturnService implements CruiserService {
    @Override
    public void service(Request request, Response response) throws IOException {
        String data = (String) request.getData();

        String[] datas = data.split(":");

        WorkerManager.remove(datas[0]);
    }
}
