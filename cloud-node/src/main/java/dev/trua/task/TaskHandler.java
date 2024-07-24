package dev.trua.task;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskHandler {

    private final List<CloudTask> runningTasks;

    public TaskHandler() {
        runningTasks = new ArrayList<>();
    }

    public void runTask(String group) {

        final HashMap<String, Object> property = new HashMap<>();
        property.put("used_group", group);
        property.put("used_id", this.getFreeID(group));
        property.put("used_port", this.getFreePort());

        var cloudTask = new CloudTask(property);
        this.runningTasks.add(cloudTask);
    }


    private Integer getFreeID(@NonNull final String group){
        var freeID = 0;
        final var endID = Short.MAX_VALUE;
        final var usedIDs = this.runningTasks.stream()
                .filter(cloudTask -> (cloudTask.getProperty().get("used_group")).equals(group))
                .map(it -> (int) it.getProperty().get("used_id")).toList();

        for (int i = 1; i != endID ; i++) {
            if (!usedIDs.contains(i)){
                freeID = i;
                i = endID;
            }
        }
        return freeID;
    }

    private Integer getFreePort() {
        var freePort = 0;
        final var startport = 4000;
        final var endport = Short.MAX_VALUE;
        final var usedPorts = this.runningTasks.stream().map(it -> (int) it.getProperty().get("used_port")).toList();

        for (int i = startport; i != endport ; i++) {
            if (!usedPorts.contains(i)){
                freePort = i;
                i = endport;
            }
        }
        return freePort;
    }


}
