package org.herring.cruiser.core.response;

import org.herring.core.protocol.NetworkContext;
import org.herring.core.protocol.handler.MessageHandler;

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
        context.sendObject(data);
    }

    public void sendObject(Object data, MessageHandler messageHandler){
        this.messageHandler = messageHandler;
        context.sendObject(data);
    }

    public void close(){
        context.close();
    }

}
