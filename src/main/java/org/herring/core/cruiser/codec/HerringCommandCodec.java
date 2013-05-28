package org.herring.core.cruiser.codec;

import org.herring.cruiser.server.request.HerringRequestSelector;
import org.herring.protocol.codec.HerringCodec;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCommandCodec implements HerringCodec{
    @Override
    public byte[] encode(Object data) throws Exception {
        ByteBuffer byteBuffer = (ByteBuffer) data;
        return byteBuffer.array();
    }

    @Override
    public Object decode(byte[] packet) throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap(packet);
        HerringRequestSelector.select(buffer);
        return buffer;
    }
}
