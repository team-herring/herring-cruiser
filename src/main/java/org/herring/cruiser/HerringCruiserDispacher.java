package org.herring.cruiser;


import org.herring.cruiser.request.Response;
import org.herring.cruiser.request.analysis.Request;
import org.herring.cruiser.request.analysis.RequestRMI;
import org.herring.cruiser.service.HerringService;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserDispacher implements Runnable {
    private final Map<String, HerringService> serviceMap;
    private Socket socket;
    private Request request;

    public HerringCruiserDispacher(Map<String, HerringService> serviceMap, Socket socket) {
        this.serviceMap = serviceMap;
        this.socket= socket;
        this.request = new RequestRMI();
    }

    @Override
    public void run() {
        Response response = null;
        try {
            request.analysis(socket.getInputStream());
            response = new Response(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert request != null;
            assert response != null;
            request.close();
            response.close();
        }

    }
}
