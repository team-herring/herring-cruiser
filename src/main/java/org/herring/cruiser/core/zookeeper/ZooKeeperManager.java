package org.herring.cruiser.core.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.herring.core.cluster.zookeeper.ZookeeperClient;

import java.io.IOException;
import java.util.*;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ZooKeeperManager {
    public static final String BASE_PATH = "cruiser/jobs/";
    public static final String TOPOLOGY_DIRECTORY = "/topology/";
    public static final String EVENT_DIRECTORY = "/event/";
    public static final String COLLECTOR_DIRECTORY = "collector/";
    public static final String WORK_DIRECTORY = "work/";
    public static final String AGGREGATION_DIRECTORY = "aggregation/";

    private static final Map<String, List<JobEvent>> eventMap;
    private static ZookeeperClient zkClient;

    static {
        eventMap = new HashMap<String, List<JobEvent>>();

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("zookeeper.properties"));
            String uri = properties.getProperty("zookeeper.server-uri");
            int timeout = Integer.valueOf(properties.getProperty("zookeeper.timeout"));
            zkClient = new ZookeeperClient(uri, timeout, ClassLoader.getSystemResource("jass.conf").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String path, String data, boolean isPersitent) throws KeeperException {
            zkClient.createFile(BASE_PATH + path, data, isPersitent);
    }

    public static void createDirectory(String path) throws KeeperException {
        zkClient.createDirectory(path);
    }

    public static void deleteDirectory(int jobID) throws KeeperException {
        zkClient.delete(BASE_PATH + jobID);
    }

    public static void createJob(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH+jobID);
    }

    public static void createTopologyDirectory(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH+jobID+TOPOLOGY_DIRECTORY);
    }

    public static void createEventDirectory(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH+jobID+EVENT_DIRECTORY);
    }

    public static void createCollector(int jobID, String collectorName) throws KeeperException {
        ZooKeeperManager.createDirectory(jobID + TOPOLOGY_DIRECTORY + COLLECTOR_DIRECTORY + collectorName);
        ZooKeeperManager.createDirectory(jobID + EVENT_DIRECTORY + COLLECTOR_DIRECTORY + collectorName);
    }

    public static void createWork(int jobID, String workName) throws KeeperException {
        ZooKeeperManager.createDirectory(jobID + TOPOLOGY_DIRECTORY + WORK_DIRECTORY + workName);
        ZooKeeperManager.createDirectory(jobID + EVENT_DIRECTORY + WORK_DIRECTORY + workName);
    }

    public static void createAggregation(int jobID, String aggregationName) throws KeeperException {
        ZooKeeperManager.createDirectory(jobID + TOPOLOGY_DIRECTORY + AGGREGATION_DIRECTORY + aggregationName);
        ZooKeeperManager.createDirectory(jobID + EVENT_DIRECTORY + AGGREGATION_DIRECTORY + aggregationName);
    }

    public static void addListener(String path, JobEvent event) {
        if (!eventMap.containsKey(path))
            eventMap.put(path, new ArrayList<JobEvent>());
        List<JobEvent> events = eventMap.get(path);
        events.add(event);

        //주키퍼 등록
    }

    public static void remove(String path) {
        eventMap.remove(path);
    }
}
