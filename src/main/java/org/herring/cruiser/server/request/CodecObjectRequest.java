package org.herring.cruiser.server.request;

import org.herring.cruiser.core.model.JobCommand;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CodecObjectRequest implements Request<JobCommand> {
    private String uuid;
    private JobCommand jobCommand;

    public CodecObjectRequest(ByteBuffer byteBuffer) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteBuffer.array());
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
    public String getID() {
        return this.uuid;
    }

    @Override
    public JobCommand getData() {
        return this.jobCommand;
    }
}
