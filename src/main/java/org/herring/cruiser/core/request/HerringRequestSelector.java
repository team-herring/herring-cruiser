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
    public static Request select(ByteBuffer buffer) throws IOException, ClassNotFoundException {
        byte command = buffer.get();
        byte [] datas = buffer.array();

        Request request = null;
        if (command == 1){
            request = new CodecObjectRequest(ByteBuffer.wrap(datas));
        }
        if (command == 2){
            request = new CodecObjectRequest(ByteBuffer.wrap(datas));
        }

        return request;
    }
}
