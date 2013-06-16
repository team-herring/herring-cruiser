package org.herring.cruiser.core.zookeeper;

import org.herring.core.cluster.zookeeper.ZookeeperClient;
import org.herring.cruiser.job.Group;

import java.io.IOException;
import java.util.*;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ZooKeeperManager {
    public static final String TOPOLOGY_DIRECTORY = "/topology";
    public static final String EVENT_DIRECTORY = "/event";
    private static final String BASE_PATH = "cruiser/jobs/";
    private static final Map<String, List<JobEvent>> eventMap;
    private static ZookeeperClient zkClient;

    static {
        eventMap = new HashMap<String, List<JobEvent>>();

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("zookeeper.properties"));
            String uri = properties.getProperty("zookeeper.server-uri");
            int timeout = Integer.valueOf(properties.getProperty("zookeeper.timeout"));

            ArrayList<Boolean> watchCheck = new ArrayList<Boolean>();
            for (int i = 0; i < 3; ++i)
                watchCheck.add(false);
            zkClient = new ZookeeperClient(uri, timeout, ClassLoader.getSystemResource("jass.conf").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registJob(int jobID) {

    }

    public static void registGroup(int jobID, Group group) {

    }

    public static void createFile(String path) {

    }

    public static void createFolder(String path) {

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
