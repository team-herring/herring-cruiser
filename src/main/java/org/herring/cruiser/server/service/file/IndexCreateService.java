package org.herring.cruiser.server.service.file;

import org.herring.cruiser.container.worker.Worker;
import org.herring.cruiser.container.worker.WorkerManager;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.server.service.CruiserService;
import org.herring.protocol.NetworkContext;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class IndexCreateService implements CruiserService {
    @Override
    public void service(Request request, Response response) throws IOException {
        Worker worker = WorkerManager.find("test");

        JobCommand jobCommand = new JobCommand("1234", "RegistJobWorker");
        worker.takeWork(jobCommand, new EventHandler() {
            @Override
            public void handler(NetworkContext context, Object o) {
            }
        });
    }
}
