package org.herring.worker.server;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.DataSender;
import org.herring.cruiser.core.request.Request;
import org.herring.worker.container.JobManager;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringDataSenderFactory {
    public static DataSender create(Request request){
        JobCommand jobCommand = JobManager.find(request);
        return new DataSender(jobCommand);
    }
}
