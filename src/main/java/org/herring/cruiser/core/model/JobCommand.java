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

    private String inputGroupID;
    private String intputServiceName;

    private String outputGroupID;
    private String outputServiceName;

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

    public String getInputGroupID() {
        return inputGroupID;
    }

    public void setInputGroupID(String inputGroupID) {
        this.inputGroupID = inputGroupID;
    }

    public String getIntputServiceName() {
        return intputServiceName;
    }

    public void setIntputServiceName(String intputServiceName) {
        this.intputServiceName = intputServiceName;
    }

    public String getOutputGroupID() {
        return outputGroupID;
    }

    public void setOutputGroupID(String outputGroupID) {
        this.outputGroupID = outputGroupID;
    }

    public String getOutputServiceName() {
        return outputServiceName;
    }

    public void setOutputServiceName(String outputServiceName) {
        this.outputServiceName = outputServiceName;
    }

    public void putExtra(String key, Object val){
        this.extra.put(key, val);
    }

    public Object getExtra(String key){
        return this.extra.get(key);
    }
}
