package org.herring.cruiser.server.file;

import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.server.request.Request;
import org.herring.cruiser.server.response.Response;
import org.herring.cruiser.server.service.HerringCruiserDispacher;
import org.herring.protocol.NetworkContext;
import org.herring.protocol.ServerComponent;
import org.herring.protocol.codec.HerringCodec;
import org.herring.protocol.handler.MessageHandler;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringFileReceiveServer {
    private final static int port = 9928;

    private ServerComponent serverComponent;

    public static void main(String[] args) throws Exception {
        HerringFileReceiveServer serverInstance = new HerringFileReceiveServer();

        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public void messageArrived(NetworkContext context, Object data) throws Exception {
                Request request = (Request) data;
                Response response = new Response(context, this);
                HerringCruiserDispacher dispacher = new HerringCruiserDispacher(request, response);
                dispacher.run();
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
        } finally {
            serverInstance.serverComponent.stop();
        }
    }
}
