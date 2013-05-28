package org.herring.cruiser.server.response;

import org.herring.protocol.NetworkContext;
import org.herring.protocol.handler.MessageHandler;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Response {
    private NetworkContext context;
    private MessageHandler messageHandler;

    public Response(NetworkContext context, MessageHandler messageHandler) {
        this.context = context;
        this.messageHandler = messageHandler;
    }

    public void sendObject(Object data){
        context.sendObject(data, messageHandler);
    }

    public void sendObject(Object data, MessageHandler messageHandler){
        context.sendObject(data, messageHandler);
    }

}
