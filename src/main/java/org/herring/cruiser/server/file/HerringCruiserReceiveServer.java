package org.herring.cruiser.server.file;

import org.herring.core.protocol.NetworkContext;
import org.herring.core.protocol.ServerComponent;
import org.herring.core.protocol.codec.HerringCodec;
import org.herring.core.protocol.handler.MessageHandler;
import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.cruiser.core.setting.Servers;
import org.herring.cruiser.server.service.HerringCruiserDispatcher;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserReceiveServer {
    private final static int port = Servers.CRUISER_PORT;

    private ServerComponent serverComponent;

    public static void main(String[] args) throws Exception {
        HerringCruiserReceiveServer serverInstance = new HerringCruiserReceiveServer();

        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public boolean messageArrived(NetworkContext networkContext, Object data) throws Exception {
                Request request = (Request) data;
                Response response = new Response(networkContext, this);
                HerringCruiserDispatcher dispatcher = new HerringCruiserDispatcher(request, response);
                dispatcher.run();
                return false;
            }

            @Override
            public void channelInactive(NetworkContext context) throws Exception {
                System.out.println("연결 끊어짐: " + context.getRemoteAddress());
            }
        };

        try {
            serverInstance.serverComponent = new ServerComponent(port, codec, handler);
            serverInstance.serverComponent.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
