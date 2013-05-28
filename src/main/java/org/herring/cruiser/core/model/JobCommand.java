package org.herring.cruiser.core.model;

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


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobCommand that = (JobCommand) o;

        if (jobId != that.jobId) return false;
        if (next != that.next) return false;
        if (command != null ? !command.equals(that.command) : that.command != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = command != null ? command.hashCode() : 0;
        result = 31 * result + next;
        result = 31 * result + (int) (jobId ^ (jobId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "JobCommand{" +
                "command='" + command + '\'' +
                ", next=" + next +
                ", jobId=" + jobId +
                '}';
    }
}
