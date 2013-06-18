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
    public static final String BASE_PATH = "/cruiser/job";
    public static final String TOPOLOGY_DIRECTORY = "/topology";
    public static final String EVENT_DIRECTORY = "/event";
    public static final String COLLECTOR_DIRECTORY = "/collector";
    public static final String WORK_DIRECTORY = "/work";
    public static final String AGGREGATION_DIRECTORY = "/aggregation";

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

            if (!zkClient.exists("/cruiser"))
                zkClient.createDirectory("/cruiser");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String path, String data, boolean isPersitent) throws KeeperException {
        zkClient.createFile(BASE_PATH + path, data, isPersitent);
    }

    public static void createDirectory(String path) throws KeeperException {
        zkClient.createDirectory(BASE_PATH + path);
    }

    public static void deleteDirectory(String path) throws KeeperException {
        zkClient.delete("-r " + BASE_PATH + path);
    }

    public static void deleteDirectory(int jobID) throws KeeperException {
        if (!zkClient.exists(BASE_PATH + jobID))
            return;
        List<String> list = zkClient.getChildren(BASE_PATH + jobID);

        deleteChilden(BASE_PATH + jobID, list);
        zkClient.delete(BASE_PATH + jobID);
    }

    private static void deleteChilden(String parent, List<String> list) throws KeeperException {
        for (String name : list) {
            String path = parent + "/" + name;
            List<String> children = zkClient.getChildren(path);
            deleteChilden(path, children);
            zkClient.delete(path);
        }
    }

    public static void createJob(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH + jobID);
    }

    public static void createGroupDirectory(int jobID, String groupName) throws KeeperException {
        zkClient.createDirectory(BASE_PATH + jobID + TOPOLOGY_DIRECTORY + "/" + groupName);
        zkClient.createDirectory(BASE_PATH + jobID + EVENT_DIRECTORY + "/" + groupName);
    }

    public static void createTopologyDirectory(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH + jobID + TOPOLOGY_DIRECTORY);
    }

    public static void createEventDirectory(int jobID) throws KeeperException {
        zkClient.createDirectory(BASE_PATH + jobID + EVENT_DIRECTORY);
    }

    public static void createCollector(int jobID, String name, String collectorName) throws KeeperException {
        String topology = BASE_PATH + jobID + TOPOLOGY_DIRECTORY + "/" + name + COLLECTOR_DIRECTORY;
        String event = BASE_PATH + jobID + EVENT_DIRECTORY + "/" + name + COLLECTOR_DIRECTORY;
        zkClient.createDirectory(topology);
        zkClient.createDirectory(event);
        zkClient.createDirectory(topology + "/" + collectorName);
        zkClient.createDirectory(event + "/" + collectorName);
    }

    public static void createWork(int jobID, String name, String workName) throws KeeperException {
        String topology = BASE_PATH + jobID + TOPOLOGY_DIRECTORY + "/" + name + WORK_DIRECTORY;
        String event = BASE_PATH + jobID + EVENT_DIRECTORY + "/" + name + WORK_DIRECTORY;

        if (!zkClient.exists(topology))
            zkClient.createDirectory(topology);
        if (!zkClient.exists(event))
            zkClient.createDirectory(event);

        zkClient.createDirectory(topology + "/" + workName);
        zkClient.createDirectory(event + "/" + workName);
    }

    public static void createAggregation(int jobID, String name, String aggregationName) throws KeeperException {
        String topology = BASE_PATH + jobID + TOPOLOGY_DIRECTORY + "/" + name + AGGREGATION_DIRECTORY;
        String event = BASE_PATH + jobID + EVENT_DIRECTORY + "/" + name + AGGREGATION_DIRECTORY;

        zkClient.createDirectory(topology);
        zkClient.createDirectory(event);
        zkClient.createDirectory(topology + "/" + aggregationName);
        zkClient.createDirectory(event + "/" + aggregationName);
    }

    public static void createInformationFile(int jobID, String groupName, String fileName, String data) throws KeeperException {
        String topology = BASE_PATH + jobID + TOPOLOGY_DIRECTORY + "/" + groupName + "/" + fileName;

        zkClient.createFile(topology, data, true);
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
