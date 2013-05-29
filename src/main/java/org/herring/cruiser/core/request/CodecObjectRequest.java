package org.herring.cruiser.core.request;

import org.herring.cruiser.core.model.JobCommand;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CodecObjectRequest implements Request<JobCommand> {
    private String uuid;
    private JobCommand jobCommand;

    public CodecObjectRequest(byte[] datas) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(datas);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        this.jobCommand = (JobCommand) objectInputStream.readObject();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getCommand() {
        return jobCommand.getCommand();
    }

    @Override
    public String getJobID() {
        return this.uuid;
    }

    @Override
    public JobCommand getData() {
        return this.jobCommand;
    }
}
