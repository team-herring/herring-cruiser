package org.herring.cruiser.core.request;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CodecDataRequest implements Request<ByteBuffer>{
    private byte[] byteBuffer;
    private String uuid;


    public CodecDataRequest(byte[] byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public int getSize() {
        return byteBuffer.length;
    }

    @Override
    public int getCommand() {
        return 2;
    }

    @Override
    public ByteBuffer getData() {
        return ByteBuffer.wrap(byteBuffer);
    }
}
