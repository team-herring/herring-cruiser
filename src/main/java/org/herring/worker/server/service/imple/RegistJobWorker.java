package org.herring.worker.server.service.imple;

import org.apache.log4j.Logger;
import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.service.listener.AgentListener;

import java.util.List;


/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class RegistJobWorker extends AgentListener<String> {
    private static final Logger logging = Logger.getLogger(RegistJobWorker.class);

    @Override
    public List<String> listen(Request request, List<String> values, NextWorker nextWorker) {

        return null;
    }
}
