package org.herring.worker.server.service;

import org.apache.log4j.Logger;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.NextWorker;
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
    private static final Logger logging= Logger.getLogger(RegistJobWorker.class);

    @Override
    public void service(Request request, Response response, NextWorker nextWorker) {
        JobCommand jobcommand = (JobCommand) request.getData();
        JobManager.regist(jobcommand);

        logging.info("JobCommand regist : "+ jobcommand);
    }
}
