package org.herring.cruiser.core.network;

import org.herring.core.protocol.ClientComponent;
import org.herring.core.protocol.NetworkContext;
import org.herring.core.protocol.codec.HerringCodec;
import org.herring.core.protocol.handler.MessageHandler;
import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class MessageSender {
    private static final byte message = 1;
    private ClientComponent clientComponent = null;
    private String ip;
    private int port;

    public MessageSender(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void sendJobCommand(JobCommand jobCommand, EventHandler eventHandler) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(jobCommand);

        ByteBuffer buffer = ByteBuffer.wrap(outputStream.toByteArray());
        send(buffer, eventHandler);
    }

    public void send(ByteBuffer buffer, final EventHandler eventHandler) {
        ByteBuffer messageBuffer = ByteBuffer.allocate(buffer.capacity() + 1);
        messageBuffer.position(1);
        messageBuffer.put(buffer);
        messageBuffer.put(0, message);
        messageBuffer.position(0);


        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public boolean messageArrived(NetworkContext networkContext, Object o) throws Exception {
                return false;
            }

            @Override
            public void channelInactive(NetworkContext context) throws Exception {
                System.out.println("연결 끊어짐");
            }

            @Override
            public void networkStopped() throws Exception {
                System.out.println("네트워크 종료됨");
            }
        };

        try {
            clientComponent = new ClientComponent(ip, port, codec, handler);
            clientComponent.start();
            clientComponent.getNetworkContext().getChannel().write(messageBuffer);
            clientComponent.getNetworkContext().getChannel().flush();
        } catch (Exception e) {
            e.printStackTrace();
            clientComponent.stop();
        }
    }
}
