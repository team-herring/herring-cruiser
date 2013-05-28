package org.herring.cruiser.core.request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface Request<T> {
    public int getSize();
    public String getCommand();
    public String getID();
    public T getData();
}
