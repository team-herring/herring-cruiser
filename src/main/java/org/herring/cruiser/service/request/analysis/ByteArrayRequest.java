package org.herring.cruiser.service.request.analysis;

import org.herring.cruiser.service.request.Request;
import org.herring.core.cruiser.model.RequestPolicy;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ByteArrayRequest implements Request {
    private byte[] bytes;
    private String id;
    private int size = -1;
    private int command = -1;
    private ByteBuffer dataBuffer;

    public ByteArrayRequest(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getSize() {
        if (size != -1)
            return size;
        byte[] result = getUsefulBytes(RequestPolicy.SIZE_START, RequestPolicy.SIZE_SIZE);
        size = bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
        return size;
    }

    public String getID() {
        if (id != null)
            return id;

        byte[] result = getUsefulBytes(RequestPolicy.ID_START, RequestPolicy.ID_SIZE);
        id = new String(result);
        return id;
    }

    public int getCommand() {
        if (command != -1)
            return command;
        byte[] result = getUsefulBytes(RequestPolicy.COMMAND_START, RequestPolicy.COMMAND_SIZE);
        command = bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
        return command;
    }

    public ByteBuffer getData() {
        if (dataBuffer != null)
            return dataBuffer;
        byte[] result = getUsefulBytes(RequestPolicy.DATA_START, RequestPolicy.COMMAND_SIZE);
        return ByteBuffer.wrap(bytes);
    }

    private byte[] getUsefulBytes(int start, int size) {
        byte[] result = new byte[size];
        int index = 0;
        for (int i = start; i < size; i++) {
            result[index] = bytes[i];
            index++;
        }
        return result;
    }
}
