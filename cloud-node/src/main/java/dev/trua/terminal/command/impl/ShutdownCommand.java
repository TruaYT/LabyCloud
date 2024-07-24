package dev.trua.terminal.command.impl;

import dev.trua.CloudNode;
import dev.trua.terminal.TerminalLogger;
import dev.trua.terminal.command.Command;

import java.util.List;

public final class ShutdownCommand extends Command {

    private boolean confirm = false;

    public ShutdownCommand() {
        super("shutdown", List.of("exit"), "shutdown the cloud-system", null);
    }

    @Override
    public void execute(String[] args) {
        if (!confirm) {
            TerminalLogger.error("you really want to shutdown the cloud-system? if yes, use the command again!");
            confirm = true;
            return;
        }

        TerminalLogger.info("try to stop the cloud-system");
        CloudNode.instance().stop();
    }

    @Override
    public void usage() {

    }
}
