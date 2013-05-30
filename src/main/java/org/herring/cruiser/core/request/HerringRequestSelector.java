package org.herring.cruiser.core.request;

import java.io.IOException;
import java.util.Arrays;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringRequestSelector {
    public static Request select(byte[] buffer) throws IOException, ClassNotFoundException {
        byte command = buffer[0];
        System.out.println(buffer.length);
        byte[] datas = Arrays.copyOfRange(buffer, 1, buffer.length);
//        ByteBuffer datas = ByteBuffer.allocate(buffer.length-1);
//        datas.put(buffer, 1, buffer.length-1);

        Request request = null;
        if (command == (byte) 1) {
            request = new CodecObjectRequest(datas);
        }
        if (command == (byte) 2) {
            request = new CodecObjectRequest(datas);
        }

        return request;
    }
}
