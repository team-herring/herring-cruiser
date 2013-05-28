package org.herring.worker.server.service;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.DataSender;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.worker.container.JobManager;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class RegistJobWorker implements WorkerService{
    @Override
    public void service(Request request, Response response, DataSender dataSender) {
        JobCommand jobcommand = (JobCommand) request.getData();
        JobManager.regist(request.getJobID(), jobcommand);
        System.out.println(jobcommand);
    }
}
