package org.herring.cruiser.container.worker;

import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CruiserSerivce {
    private String ip;
    private int port;

    public CruiserSerivce(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void send(){

    }

    public void takeWork(JobCommand jobCommand, EventHandler eventHandler) {


    }
}
