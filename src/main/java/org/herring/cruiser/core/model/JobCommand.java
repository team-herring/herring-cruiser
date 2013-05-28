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
    private String nextServerIP;
    private int nextServerPort;
    private String jobId;

    public JobCommand(String jobId, String command) {
        this.jobId = jobId;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getNextServerIP() {
        return nextServerIP;
    }

    public void setNextServerIP(String nextServerIP) {
        this.nextServerIP = nextServerIP;
    }

    public int getNextServerPort() {
        return nextServerPort;
    }

    public void setNextServerPort(int nextServerPort) {
        this.nextServerPort = nextServerPort;
    }

    @Override
    public String toString() {
        return "JobCommand{" +
                "command='" + command + '\'' +
                ", nextServerIP='" + nextServerIP + '\'' +
                ", nextServerPort=" + nextServerPort +
                ", jobId='" + jobId + '\'' +
                '}';
    }
}
