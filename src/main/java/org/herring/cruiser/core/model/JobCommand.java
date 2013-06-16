package org.herring.cruiser.core.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class JobCommand implements Serializable{
    private static final long serialVersionUID = -295417751909939119L;
    private int command;
    private int jobID;
    private int groupID;
    private String serviceName;
    private String field;

    private int nextGroupID;
    private int nextServiceID;
    private Map<String, Object> extra;

    public JobCommand() {
    }

    public JobCommand(int jobID, int groupID, String serviceName) {
        this.jobID = jobID;
        this.groupID = groupID;
        this.serviceName = serviceName;
    }

    public int getCommand() {
        return command;
    }

    public int getJobID() {
        return jobID;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getNextGroupID() {
        return nextGroupID;
    }

    public void setNextGroupID(int nextGroupID) {
        this.nextGroupID = nextGroupID;
    }

    public int getNextServiceID() {
        return nextServiceID;
    }

    public void setNextServiceID(int nextServiceID) {
        this.nextServiceID = nextServiceID;
    }

    public void putExtra(String key, Object val){
        this.extra.put(key, val);
    }

    public Object getExtra(String key){
        return this.extra.get(key);
    }
}
