package org.herring.cruiser.core.command;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public enum Commands {
    WORKER_CREATE(1), WORKER_DESTROY(2);


    private int value;

    private Commands(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public ByteBuffer getByteBuffer(){
        ByteBuffer buffer =ByteBuffer.allocate(4);
        return buffer.putInt(value);
    }
}
