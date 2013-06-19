package org.herring.cruiser.core.codec;

import org.herring.core.protocol.codec.HerringCodec;
import org.herring.cruiser.core.request.HerringRequestSelector;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserCodec implements HerringCodec {
    @Override
    public byte[] encode(Object data) throws Exception {
        ByteBuffer byteBuffer = (ByteBuffer) data;
        return byteBuffer.array();
    }

    @Override
    public Object decode(byte[] packet) throws Exception {
        return HerringRequestSelector.select(packet);
    }
}
