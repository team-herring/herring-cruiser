package org.herring.cruiser.core.event;

import org.herring.protocol.NetworkContext;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface EventHandler<T> {
    void handler(NetworkContext context, T t);
}
