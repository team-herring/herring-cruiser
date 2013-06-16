package org.herring.cruiser.core.service.listener;

import org.herring.cruiser.core.network.NextWorker;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.service.work.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public abstract class Listener<T> extends Work {
    protected List<T> values;

    protected Listener() {
        this.values = new ArrayList<T>();
        create(values);
    }

    @Override
    public void working(Request request, NextWorker nextWorker) {
        List<T> results = listen(request, values, nextWorker);
        values.addAll(results);
    }

    public void create(List<T> values) {
    }

    public abstract List<T> listen(Request request, List<T> values, NextWorker nextWorker);
}
