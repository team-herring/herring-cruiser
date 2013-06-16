package org.herring.cruiser.core.request;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class CodecDataRequest implements Request<ByteBuffer>{
    private ByteBuffer byteBuffer;
    private String uuid;


    public CodecDataRequest(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getCommand() {
        return 0;
    }

    @Override
    public ByteBuffer getData() {
        return null;
    }
}
