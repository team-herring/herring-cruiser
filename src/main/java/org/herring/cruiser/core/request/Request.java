package org.herring.cruiser.core.request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface Request<T> {
    public int getSize();
    public int getCommand();
    public int getJobID();
    public int getStepID();
    public T getData();
}
