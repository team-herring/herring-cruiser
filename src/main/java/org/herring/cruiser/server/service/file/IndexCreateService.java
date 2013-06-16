package org.herring.cruiser.server.service.file;

import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.core.service.group.GroupBy;
import org.herring.cruiser.core.service.work.CreateIndex;
import org.herring.cruiser.core.service.work.DataStore;
import org.herring.cruiser.job.Group;
import org.herring.cruiser.job.Job;
import org.herring.cruiser.server.service.CruiserService;
import org.herring.worker.server.service.imple.ColumnAnalyzer;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class IndexCreateService implements CruiserService {
    @Override
    public void service(Request request, Response response) throws IOException {
        Job job = new Job();

        Group analyzer = new Group("analyzer");
        analyzer.addWork(new ColumnAnalyzer());
        analyzer.output("index");

        Group index = new Group("index");
        index.group(new GroupBy());
        index.input("analyzer");
        index.addWork(new CreateIndex());
        index.output("store");

        Group store = new Group("store");
        store.group(new GroupBy());
        store.input("index");
        store.addWork(new DataStore());

        job.append(analyzer);
        job.append(index);
        job.append(store);

        job.start();
    }
}
