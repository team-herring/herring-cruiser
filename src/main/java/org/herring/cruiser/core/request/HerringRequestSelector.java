package org.herring.cruiser.core.request;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringRequestSelector {
    public static Request select(byte[] buffer) throws IOException, ClassNotFoundException {
        byte command = buffer[0];
        ByteBuffer datas = ByteBuffer.wrap(buffer, 1, buffer.length);

        Request request = null;
        if (command == (byte) 1) {
            request = new CodecObjectRequest(datas.array());
        }
        if (command == (byte) 2) {
            request = new CodecObjectRequest(datas.array());
        }

        return request;
    }
}
