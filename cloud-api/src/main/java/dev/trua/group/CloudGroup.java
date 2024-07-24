package dev.trua.group;

import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.file.Path;

@Data
@Accessors(fluent = true)
public class CloudGroup {

    private String name;
    private GroupType groupType;
    private String version;
    private boolean staticGroup;
    private int maxMemory;
    private int minOnline;
    private int maxOnline;
    private int slots;
    private boolean maintenance;
    private int priority;
    private Path templateDir;

}
