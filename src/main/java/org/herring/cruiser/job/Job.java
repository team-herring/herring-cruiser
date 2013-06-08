package org.herring.cruiser.job;

import org.herring.cruiser.container.sequence.JobSequence;
import org.herring.cruiser.job.step.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Job {
    private List<Step> steps;
    private int id = JobSequence.get();

    public Job() {
        steps = new ArrayList<Step>();
    }

    public void append(Step step){
        steps.add(step);
    }

    public void start(){
        for (Step step : steps)
            step.start();
    }

    public int getId(){
        return this.id;
    }
}
