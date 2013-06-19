package org.herring.cruiser.core.model;

import java.io.Serializable;
import java.util.HashMap;
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
    private String groupName;
    private String serviceName;
    private String field;

    private String inputGroupID;
    private String intputServiceName;

    private String outputGroupID;
    private String outputServiceName;

    private Map<String, Object> extra;

    public JobCommand() {
    }

    public JobCommand(int jobID, String groupName, String serviceName) {
        this.jobID = jobID;
        this.groupName = groupName;
        this.serviceName = serviceName;
    }

    public int getCommand() {
        return command;
    }

    public int getJobID() {
        return jobID;
    }

    public String getGroupName() {
        return groupName;
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
        if (extra != null)
            extra = new HashMap<String, Object>();
        this.extra.put(key, val);
    }

    public Object getExtra(String key){
        return this.extra.get(key);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobCommand that = (JobCommand) o;

        if (jobID != that.jobID) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobID;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }

    public JobCommand copy(){
        return new JobCommand(jobID, groupName, serviceName);
    }
}
