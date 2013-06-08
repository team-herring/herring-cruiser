package org.herring.cruiser.job.step.service;

import org.herring.cruiser.container.job.JobCommandManager;
import org.herring.cruiser.core.command.WorkerServiceCommand;
import org.herring.cruiser.core.model.JobCommand;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class And implements Service {
    @Override
    public JobCommand getJobCommand() {
        return JobCommandManager.createAndRegist(WorkerServiceCommand.get("and"));
    }
}
