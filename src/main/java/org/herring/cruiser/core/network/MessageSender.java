package org.herring.cruiser.core.network;

import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.protocol.ClientComponent;
import org.herring.protocol.NetworkContext;
import org.herring.protocol.codec.HerringCodec;
import org.herring.protocol.handler.MessageHandler;

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

    public void send(ByteBuffer buffer, final EventHandler eventHandler) {
        ByteBuffer messageBuffer = ByteBuffer.allocate(buffer.capacity()+1);
        messageBuffer.position(1);
        messageBuffer.put(buffer);
        messageBuffer.put(0, message);
        messageBuffer.position(0);


        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public void messageArrived(NetworkContext context, Object data) throws Exception {
                eventHandler.handler(context, data);
//                clientComponent.stop();
            }

            @Override
            public void channelReady(NetworkContext context) throws Exception {
                System.out.println("연결 준비");
            }

            @Override
            public void channelInactive(NetworkContext context) throws Exception {
                System.out.println("연결 끊어짐");
            }

            @Override
            public void channelClosed(NetworkContext context) throws Exception {
                System.out.println("연결 종료됨");
            }

            @Override
            public void networkStopped() throws Exception {
                System.out.println("네트워크 종료됨");
            }
        };

        try {
            clientComponent = new ClientComponent(ip, port, codec, handler);
            clientComponent.start();
            clientComponent.getChannel().write(messageBuffer);
            clientComponent.getChannel().flush();
        } catch (Exception e) {
            e.printStackTrace();
            clientComponent.stop();
        }
    }
}
