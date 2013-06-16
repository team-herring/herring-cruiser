package org.herring.worker.server;

import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringDataSenderFactory {
    public static NextWorker create(Request request){
        return new NextWorker((JobCommand) request.getData());
    }
}
