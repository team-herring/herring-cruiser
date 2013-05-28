package org.herring.cruiser.server.service.file;

import org.herring.cruiser.container.worker.CruiserSerivce;
import org.herring.cruiser.container.worker.WorkerManager;
import org.herring.cruiser.server.request.Request;
import org.herring.cruiser.server.response.Response;
import org.herring.cruiser.server.service.CruiserService;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class IndexCreateService implements CruiserService {
    @Override
    public void service(Request request, Response response){
        CruiserSerivce cruiserSerivce = WorkerManager.find("basic");



    }
}
