package org.herring.cruiser.core.codec;

import org.herring.core.protocol.codec.HerringCodec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobCodec implements HerringCodec {
    @Override
    public byte[] encode(Object data) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(data);

        return outputStream.toByteArray();
    }

    @Override
    public Object decode(byte[] packet) throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(packet);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return objectInputStream.readObject();
    }
}
