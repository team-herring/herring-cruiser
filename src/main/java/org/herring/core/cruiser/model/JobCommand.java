package org.herring.core.cruiser.model;

import java.io.Serializable;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobCommand implements Serializable{
    private static final long serialVersionUID = -295417751909939119L;
    private String command;
    private int next;
    private long jobId;
    private long reciveSize;
}
