package org.herring.cruiser.container.worker;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class Worker {
    private String ip;
    private int port;
    private AtomicInteger jobCount;

    public Worker(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.jobCount = new AtomicInteger(1);
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (jobCount != worker.jobCount) return false;
        if (port != worker.port) return false;
        if (ip != null ? !ip.equals(worker.ip) : worker.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    public void decrease() {
        jobCount.getAndDecrement();
    }
    public void increase(){
        jobCount.getAndIncrement();
    }
}
