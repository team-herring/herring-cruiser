package org.herring.cruiser;


import org.herring.cruiser.service.request.Response;
import org.herring.cruiser.service.request.analysis.Request;
import org.herring.cruiser.service.request.analysis.RequestRMI;

import java.io.IOException;
import java.net.Socket;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class HerringCruiserDispacher implements Runnable {
    private Socket socket;
    private Request request;

    public HerringCruiserDispacher(Socket socket) {
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
