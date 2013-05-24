package org.herring.cruiser.server.request;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class NextRequest implements Request {
    private final String id;
    private final ByteBuffer command;
    private final ByteBuffer data;
    private final int size;

    public NextRequest(Request request, int command, ByteBuffer data) {
        this.id = request.getID();
        this.command = ByteBuffer.allocate(4).putInt(command);
        this.data = data;
        this.size = data.capacity();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCommand() {
        return command.getInt();
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public ByteBuffer getData() {
        return data;
    }
}
