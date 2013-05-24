package org.herring.cruiser.server.request;

import java.nio.ByteBuffer;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface Request {
    public int getSize();
    public int getCommand();
    public String getID();
    public ByteBuffer getData();
}
