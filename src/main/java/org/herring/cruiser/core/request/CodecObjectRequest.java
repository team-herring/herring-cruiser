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
    private int stepID;
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

    @Override
    public int getJobID() {
        return jobID;
    }

    @Override
    public int getStepID() {
        return stepID;
    }

    @Override
    public JobCommand getData() {
        return this.jobCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodecObjectRequest that = (CodecObjectRequest) o;

        if (jobID != that.jobID) return false;
        if (serviceID != that.serviceID) return false;
        if (stepID != that.stepID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobID;
        result = 31 * result + stepID;
        result = 31 * result + serviceID;
        return result;
    }
}
