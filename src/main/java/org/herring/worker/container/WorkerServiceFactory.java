package org.herring.worker.container;

import org.apache.log4j.Logger;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.service.WorkerService;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerServiceFactory {
    private static final Logger log = Logger.getLogger(WorkerServiceFactory.class);

    public static WorkerService create(JobCommand jobCommand) {
        String className = jobCommand.getServiceName();
        try {
            return (WorkerService) Class.forName(className).newInstance();
        } catch (Exception ignored){
            log.error(ignored.getStackTrace());
        }
        return null;
    }
}
