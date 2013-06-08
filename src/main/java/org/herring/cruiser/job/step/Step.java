package org.herring.cruiser.job.step;

import org.herring.cruiser.container.sequence.StepSequence;
import org.herring.cruiser.container.worker.Worker;
import org.herring.cruiser.container.worker.WorkerManager;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.job.step.service.Service;
import org.herring.protocol.NetworkContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Step {
    private List<Service> services;
    private Service chart;
    private int id = StepSequence.get();

    public Step() {
        services = new ArrayList<Service>();
    }

    public void addService(Service service){
        services.add(service);
    }

    public void addChart(Service service){
        chart = service;
    }

    public void start() {
        for (Service service : services) {
            try {
                Worker worker = WorkerManager.get();
                worker.takeWork(service.getJobCommand(), new EventHandler() {
                    @Override
                    public void handler(NetworkContext context, Object o) {
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
