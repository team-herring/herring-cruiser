package org.herring.cruiser.core.zookeeper;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface JobEvent {
    void push(JobEventMode mode, Object data);
}
