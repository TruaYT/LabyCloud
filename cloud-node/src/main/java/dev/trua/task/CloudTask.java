package dev.trua.task;

import lombok.Getter;

import java.util.HashMap;

public final class CloudTask {

    @Getter
    private final HashMap<String, Object> property;
    private Process process;

    public CloudTask(HashMap<String, Object> property){
        this.property = property;
    }

    public void run() {
        var builder = new ProcessBuilder();
        builder.command(" ");
    }



}
