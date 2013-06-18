package org.herring.cruiser.core.request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface Request<T> {
    int getSize();
    int getCommand();
    T getData();
    String id();
}
