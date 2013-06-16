package org.herring.cruiser.core.service.listener;

import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.core.service.WorkerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public abstract class Listener<T> implements WorkerService {
    protected List<T> values;

    protected Listener() {
        this.values = new ArrayList<T>();
        create(values);
    }

    @Override
    public void service(Request request, Response response, NextWorker nextWorker) {
        List<T> results = listen(request, values, nextWorker);
        values.addAll(results);
    }

    public void create(List<T> values){
    }
    public abstract List<T> listen(Request request, List<T> values, NextWorker nextWorker);
}
