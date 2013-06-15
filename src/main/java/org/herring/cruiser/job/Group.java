package org.herring.cruiser.job;

import org.herring.cruiser.core.service.aggregate.Aggregation;
import org.herring.cruiser.core.service.work.Work;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Group {
    private String field;
    private String input;
    private String output;
    private List<Work> works;
    private org.herring.cruiser.core.service.group.Group group;
    private Aggregation aggregation;

    public Group(String field) {
        this.field = field;
    }

    public void group(org.herring.cruiser.core.service.group.Group group) {
        this.group = group;
    }

    public void input(String name) {
        this.input = name;
    }

    public void output(String name) {
        this.output = name;
    }

    public void addWork(Work work) {
        this.works.add(work);
    }

    public void aggregate(Aggregation aggregation){
        this.aggregation = aggregation;
    }
}
