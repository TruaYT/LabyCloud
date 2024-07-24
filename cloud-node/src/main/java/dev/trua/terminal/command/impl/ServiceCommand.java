package dev.trua.terminal.command.impl;

import dev.trua.terminal.TerminalLogger;
import dev.trua.terminal.command.Command;

import java.util.List;

public final class ServiceCommand extends Command {

    public ServiceCommand() {
        super("service", List.of("serv", "services"), "manage the services", "<list, start, stop, stopgroup> <name>");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            if (!(args[0].equalsIgnoreCase("list"))) {
                this.usage();
                return;
            }
            // TODO: show all service + State;
        }

        if (args.length == 2 || args.length == 3) {
            if (args[0].equalsIgnoreCase("start")) {
                final String serviceName = args[1];
                int amount = 1;
                if (args.length == 3) {
                    amount = Integer.valueOf(args[2]);
                }

            }
            if (args[0].equalsIgnoreCase("stop")) {
                final String serviceName = args[1];
            }
            if (args[0].equalsIgnoreCase("stopgroup")) {
                final String serviceName = args[1];
            }
            this.usage();
            return;
        }

        this.usage();
    }

    @Override
    public void usage() {
        TerminalLogger.info("service list");
        TerminalLogger.info("service start <group> <[amount]>");
        TerminalLogger.info("service stop <name>");
        TerminalLogger.info("service stopgroup <group>");
    }

}
