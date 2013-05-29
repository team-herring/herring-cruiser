package org.herring.cruiser.container.worker;

import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.network.MessageSender;

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
public class Worker {
    private String ip;
    private int port;

    public Worker(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void takeWork(JobCommand jobCommand, EventHandler eventHandler) throws IOException {
        jobCommand.setNextServerIP(ip);
        jobCommand.setNextServerPort(port);


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(jobCommand);

        ByteBuffer buffer = ByteBuffer.wrap(outputStream.toByteArray());
        MessageSender sender = new MessageSender(ip, port);
        sender.send(buffer, eventHandler);
    }

    public void nextWorker(Worker worker) {
        this.ip = worker.getIp();
        this.port = worker.getPort();
    }
}
