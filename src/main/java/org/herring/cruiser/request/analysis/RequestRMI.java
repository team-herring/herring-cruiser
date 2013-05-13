package org.herring.cruiser.request.analysis;

import org.herring.core.cruiser.model.HerringCruiserCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class RequestRMI implements Request{
    private ObjectInput objectInput;

    @Override
    public void analysis(InputStream in) throws Exception {
        this.objectInput = new ObjectInputStream(in);
    }

    public HerringCruiserCommand readHerringCruiserCommand() throws IOException, ClassNotFoundException {
        return (HerringCruiserCommand) this.objectInput.readObject();
    }

    @Override
    public void close(){
        try {
            objectInput.close();
        } catch (IOException e) {
            try {
                objectInput.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
