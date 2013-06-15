package org.herring.cruiser.job;

import org.herring.cruiser.core.service.aggregate.Aggregation;
import org.herring.cruiser.core.service.group.Collector;
import org.herring.cruiser.core.service.work.Work;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Group {
    private String name;
    private String input;
    private String output;
    private List<Work> works;
    private Collector collector;
    private Aggregation aggregation;

    public Group(String name) {
        this.name = name;
    }

    public void group(Collector collector) {
        this.collector = collector;
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

    public void start() {
        for (Work work : works) {

        }
    }
}
