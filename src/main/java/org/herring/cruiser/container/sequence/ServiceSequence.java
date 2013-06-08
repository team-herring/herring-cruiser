package org.herring.cruiser.container.sequence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ServiceSequence {
    private static final AtomicInteger sequence = new AtomicInteger();

    public static int get() {
        return sequence.incrementAndGet();
    }
}
