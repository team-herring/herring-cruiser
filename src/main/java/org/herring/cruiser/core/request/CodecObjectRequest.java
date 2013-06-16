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
    private JobCommand jobCommand;
    private int jobID;
    private int serviceID;

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
    public int getCommand() {
        return jobCommand.getCommand();
    }

    public int getJobID() {
        return jobID;
    }

    @Override
    public JobCommand getData() {
        return this.jobCommand;
    }
}
