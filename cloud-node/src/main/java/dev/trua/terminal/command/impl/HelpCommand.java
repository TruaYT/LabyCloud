package dev.trua.terminal.command.impl;

import dev.trua.CloudNode;
import dev.trua.terminal.TerminalLogger;
import dev.trua.terminal.command.Command;

import java.util.List;

public final class HelpCommand extends Command {

    public HelpCommand() {
        super("help", List.of("?"), "get help for the Cloud", null);
    }

    @Override
    public void execute(String[] args) {
        CloudNode.instance().terminalHandler().commandHandler().commands().forEach(command -> {
            String arguments = command.args() == null ? "" : " " + command.args();
            TerminalLogger.info(command.command() + arguments + " - " + command.description() + " [" + String.join(",", command.alias()) + "]");
        });
    }

    @Override
    public void usage() {

    }
}
