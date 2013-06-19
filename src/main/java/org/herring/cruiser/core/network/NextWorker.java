package org.herring.cruiser.core.network;

import org.herring.core.protocol.ClientComponent;
import org.herring.core.protocol.NetworkContext;
import org.herring.core.protocol.codec.HerringCodec;
import org.herring.core.protocol.handler.MessageHandler;
import org.herring.cruiser.core.codec.HerringCruiserCodec;
import org.herring.cruiser.core.event.EventHandler;
import org.herring.cruiser.core.model.JobCommand;
import org.herring.cruiser.core.setting.Servers;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class NextWorker {
    private static final byte MESSAGE = 1;
    private static final byte DATA = 0;
    private ClientComponent clientComponent = null;
    private JobCommand jobCommand;

    private final List<Worker> fields;
    private final Object lock = new Object();

    public NextWorker(JobCommand jobCommand) {
        this.jobCommand = jobCommand;
        this.fields = new ArrayList<Worker>();
    }

    public void send(String field, ByteBuffer buffer, final EventHandler eventHandler) throws IOException {
        int i;
        synchronized (lock){
             i = Collections.binarySearch(fields, field);
        }

        if (i == -1){
            MessageSender messageSender = new MessageSender(Servers.CRUISER_IP, Servers.CRUISER_PORT);
            JobCommand sendCommand = jobCommand.copy();
            sendCommand.setField(field);
            sendCommand.setServiceName("WorkerFindService");
//            String data = (String) o;
//                            String[] datas = data.split(":");
//
//                            String ip = datas[0];
//                            int port = Integer.parseInt(datas[1]);
//                            System.out.println(ip);
//                            System.out.println(port);
        //                    sendData(fields.get(i), buffer);
            messageSender.sendJobCommand(sendCommand, new EventHandler() {
                @Override
                public void handler(NetworkContext context, Object o) {

                }
            });
        }


    }

    private void sendData(Worker worker, ByteBuffer buffer) {
        buffer.position(0);
        buffer.put(MESSAGE);
        buffer.flip();

        HerringCodec codec = new HerringCruiserCodec();

        MessageHandler handler = new MessageHandler() {
            @Override
            public boolean messageArrived(NetworkContext networkContext, Object o) throws Exception {
                clientComponent.stop();
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
            clientComponent = new ClientComponent(worker.ip, worker.port, codec, handler);
            clientComponent.start();
            clientComponent.getNetworkContext().getChannel().write(buffer);
            clientComponent.getNetworkContext().getChannel().flush();
        } catch (Exception e) {
            e.printStackTrace();
            clientComponent.stop();
        }
    }

    class Worker implements Comparable<String>{
        public String field;
        public String ip;
        public int port;

        Worker() {
        }
        Worker(String field) {
            this.field = field;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Worker worker = (Worker) o;

            if (field != null ? !field.equals(worker.field) : worker.field != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return field != null ? field.hashCode() : 0;
        }

        @Override
        public int compareTo(String o) {
            return field.compareTo(o);
        }
    }
}
