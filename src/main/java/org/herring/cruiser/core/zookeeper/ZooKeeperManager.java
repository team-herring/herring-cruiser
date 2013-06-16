package org.herring.cruiser.core.zookeeper;

import org.herring.cruiser.job.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ZooKeeperManager {
    private static final String BASE_PATH="cruiser/jobs";
    private static Map<String, List<JobEvent>> eventMap;
    static {
        eventMap = new HashMap<String, List<JobEvent>>();
    }

    public static void registJob(int jobID) {

    }

    public static void registGroup(int jobID, Group group) {

    }

    public static void createFile(String path){

    }

    public static void createFolder(String path){

    }

    public static void addListener(String path, JobEvent event){
        if ( !eventMap.containsKey(path))
            eventMap.put(path, new ArrayList<JobEvent>());
        List<JobEvent> events = eventMap.get(path);
        events.add(event);

        //주키퍼 등록
    }

    public static void remove(String path){
        eventMap.remove(path);
    }
}
