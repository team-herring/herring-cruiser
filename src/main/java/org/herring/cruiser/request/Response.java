package org.herring.cruiser.request;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Response {
    private final BufferedOutputStream buffredOutputStream;

    public Response(OutputStream out) throws IOException {
        this.buffredOutputStream = new BufferedOutputStream(out);
    }

    public void write(byte[] buffer) throws IOException {
        this.buffredOutputStream.write(buffer);
    }

    public void close(){
        try {
            this.buffredOutputStream.close();
        } catch (IOException e) {
            try {
                this.buffredOutputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
