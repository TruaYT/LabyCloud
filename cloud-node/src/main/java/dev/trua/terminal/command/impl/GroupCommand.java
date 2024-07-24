package dev.trua.terminal.command.impl;

import dev.trua.group.GroupType;
import dev.trua.terminal.TerminalLogger;
import dev.trua.terminal.command.Command;

import java.awt.geom.AffineTransform;
import java.util.List;

public final class GroupCommand extends Command {

    public GroupCommand() {
        super("group", List.of("groups"), "manage the groups", "<list, create, delete, edit> <name> values...");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            if (!(args[0].equalsIgnoreCase("list"))) {
                this.usage();
                return;
            }

            //todo: adding show all Groups;
            return;
        }

        if (args.length == 2) {
            if (!(args[0].equalsIgnoreCase("delete"))) {
                this.usage();
                return;
            }
            final String group = args[1];
            // TODO: Adding Function
            return;
        }

        if (args.length == 4) {
            if (!(args[0].equalsIgnoreCase("edit"))) {
                this.usage();
                return;
            }
            final String group = args[1];
            //todo: check if group exist?

            switch (args[2].toLowerCase()) {
                case "maxonline" -> {
                    int value = Integer.valueOf(args[3]);
                }
                case "minonline" -> {

                    int value = Integer.valueOf(args[3]);
                }
                case "memory" -> {
                    int value = Integer.valueOf(args[3]);

                }
                case "maintenance" -> {
                    boolean value = Boolean.valueOf(args[3]);
                }
                case "threads" -> {
                    int value = Integer.valueOf(args[3]);
                }
                default -> {
                    this.usage();
                }
            }
            return;
        }

        if (args.length == 7 || args.length == 8) {
            if (!(args[0].equalsIgnoreCase("edit"))) {
                this.usage();
                return;
            }
            final String group = args[1];
            //todo: check if group exist?

            final GroupType groupType = GroupType.valueOf(args[2].toUpperCase());
            final boolean staticService = Boolean.valueOf(args[3]);
            final int memory = Integer.valueOf(args[4]);
            final int minOnline = Integer.valueOf(args[5]);
            final int maxOnline = Integer.valueOf(args[6]);
            int threads = 1;
            if (args.length == 8) {
                threads = Integer.valueOf(args[7]);
            }

            return;
        }

        this.usage();
    }

    @Override
    public void usage() {
        TerminalLogger.info("group list");
        TerminalLogger.info("group create <name> <PROXY, FALLBACK, SERVER> <static> <memory> <minOnline> <maxOnline> [<threads>]");
        TerminalLogger.info("group edit <name> <maxOnline, minOnline, memory, maintenance, threads> <value>");
        TerminalLogger.info("group delete <name>");
    }
}
