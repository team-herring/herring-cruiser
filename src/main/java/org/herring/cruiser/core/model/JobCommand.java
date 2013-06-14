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
    private int stepID;
    private int serviceID;

    private int nextGroupID;
    private int nextStepID;
    private int nextServiceID;
    private Map<String, Object> extra;

    public JobCommand() {
    }

    public JobCommand(int jobID, int groupID, int stepID, int serviceID) {
        this.jobID = jobID;
        this.groupID = groupID;
        this.stepID = stepID;
        this.serviceID = serviceID;
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

    public int getStepID() {
        return stepID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public int getNextGroupID() {
        return nextGroupID;
    }

    public void setNextGroupID(int nextGroupID) {
        this.nextGroupID = nextGroupID;
    }

    public int getNextStepID() {
        return nextStepID;
    }

    public void setNextStepID(int nextStepID) {
        this.nextStepID = nextStepID;
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


    @Override
    public String toString() {
        return "JobCommand{" +
                "command=" + command +
                ", jobID=" + jobID +
                ", groupID=" + groupID +
                ", stepID=" + stepID +
                ", serviceID=" + serviceID +
                ", extra=" + extra +
                '}';
    }
}
