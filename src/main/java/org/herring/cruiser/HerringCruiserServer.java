package org.herring.cruiser;

import org.herring.cruiser.service.HerringService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserServer {
    private static ExecutorService threadPool = Executors.newCachedThreadPool();
    private static Map<String, HerringService> controllers;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                threadPool.execute(new HerringCruiserDispacher(controllers, socket));
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }
}
