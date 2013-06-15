package org.herring.worker.server;

import org.apache.log4j.Logger;
import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
import org.herring.protocol.NetworkContext;
import org.herring.protocol.ServerComponent;
import org.herring.protocol.codec.HerringCodec;
import org.herring.protocol.handler.MessageHandler;
import org.herring.worker.setting.WorkerSetting;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class WorkerServer {
    private static final Logger log = Logger.getLogger(WorkerServer.class);
    private final static int port = WorkerSetting.PORT;
    private ServerComponent serverComponent;

    public static void main(String[] args) throws Exception {
        WorkerServer serverInstance = new WorkerServer();

        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public void messageArrived(NetworkContext context, Object data) throws Exception {
                Request request = (Request) data;
                Response response = new Response(context, this);
                HerringWorkerDispacher dispacher = new HerringWorkerDispacher(request, response);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}