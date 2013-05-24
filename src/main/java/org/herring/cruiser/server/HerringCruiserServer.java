package org.herring.cruiser.server;

import org.herring.protocol.NetworkContext;
import org.herring.protocol.ServerComponent;
import org.herring.protocol.codec.HerringCodec;
import org.herring.protocol.codec.SerializableCodec;
import org.herring.protocol.handler.MessageHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserServer {
    private final static int port = 9928;

    private ServerComponent serverComponent;

    public static void main(String[] args) throws Exception {
        HerringCruiserServer serverInstance = new HerringCruiserServer();

        HerringCodec codec = new SerializableCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public void messageArrived(NetworkContext context, Object data) throws Exception {
                if ("bye".equalsIgnoreCase((String) data)) {
                    context.close(this);
                    return;
                }

                context.sendObject(data, this);
            }

            @Override
            public void channelReady(NetworkContext context) throws Exception {
                System.out.println("연결 준비: " + context.getRemoteAddress());
            }

            @Override
            public void channelInactive(NetworkContext context) throws Exception {
                System.out.println("연결 끊어짐: " + context.getRemoteAddress());
            }

            @Override
            public void channelClosed(NetworkContext context) throws Exception {
                System.out.println("연결 종료됨: " + context.getRemoteAddress());
            }
        };

        try {
            serverInstance.serverComponent = new ServerComponent(port, codec, handler);
            serverInstance.serverComponent.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (!"bye".equalsIgnoreCase(in.readLine())) ;
        } finally {
            serverInstance.serverComponent.stop();
        }
    }
}
