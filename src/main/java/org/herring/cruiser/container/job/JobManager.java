package org.herring.cruiser.container.job;

import org.herring.cruiser.container.worker.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobManager {
    private static List<Worker> workers = new ArrayList<Worker>();

    public static List<Worker> getWorkers(int number) {
        List<Worker> results = new ArrayList<Worker>();

        for (int i = 0; i < number; i++) {
            results.add(workers.get(i));
        }
        return results;
    }
}
