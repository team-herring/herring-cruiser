package org.herring.cruiser.core.codec;

import org.herring.cruiser.core.request.HerringRequestSelector;
import org.herring.protocol.codec.HerringCodec;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserCodec implements HerringCodec{
    @Override
    public byte[] encode(Object data) throws Exception {
        ByteBuffer byteBuffer = (ByteBuffer) data;
        byteBuffer.flip();
        return byteBuffer.array();
    }

    @Override
    public Object decode(byte[] packet) throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap(packet);
        return HerringRequestSelector.select(buffer);
    }
}
