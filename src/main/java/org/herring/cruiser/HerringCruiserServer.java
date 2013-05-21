package org.herring.cruiser;

import java.io.IOException;
import java.net.ServerSocket;
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


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {

        }
    }
}
