package org.herring.worker.server;

import org.apache.log4j.Logger;
import org.herring.core.protocol.NetworkContext;
import org.herring.core.protocol.ServerComponent;
import org.herring.core.protocol.codec.HerringCodec;
import org.herring.core.protocol.handler.MessageHandler;
import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.request.Request;
import org.herring.cruiser.core.response.Response;
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
            public boolean messageArrived(NetworkContext networkContext, Object data) throws Exception {
                Request request = (Request) data;
                Response response = new Response(networkContext, this);
                HerringWorkerDispacher dispacher = new HerringWorkerDispacher(request, response);
                dispacher.run();
                return true;
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