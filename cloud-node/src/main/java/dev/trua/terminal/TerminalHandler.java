package dev.trua.terminal;

import dev.trua.terminal.command.Command;
import dev.trua.terminal.command.CommandHandler;
import dev.trua.terminal.command.impl.GroupCommand;
import dev.trua.terminal.command.impl.HelpCommand;
import dev.trua.terminal.command.impl.ServiceCommand;
import dev.trua.terminal.command.impl.ShutdownCommand;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Getter
@Accessors(fluent = true)
public final class TerminalHandler extends Thread {

    private final CommandHandler commandHandler;
    private final Scanner scanner;
    private boolean runningConsole;

    public TerminalHandler() {
        this.runningConsole = true;
        this.commandHandler = new CommandHandler();
        this.scanner = new Scanner(System.in);

        this.setPriority(10);
        this.setName("LABYCLOUD_TERMINAL");

        // register Command for Console
        this.registerCommand(new HelpCommand());
        this.registerCommand(new ShutdownCommand());
        this.registerCommand(new GroupCommand());
        this.registerCommand(new ServiceCommand());
    }

    @Override
    public void run() {
        while (this.runningConsole && this.scanner.hasNext()) {
            final String rawLine = this.scanner.nextLine();
            if (rawLine.contains(" ")) {
                final String command = rawLine.split(" ")[0];
                final String[] args = rawLine.replaceFirst(command + " ", "").split(" ");
                this.commandHandler.execute(command, args);
            } else {
                this.commandHandler.execute(rawLine, new String[]{""});
            }
        }
    }

    public void handelCloseTerminal() {
        this.runningConsole = false;
        this.interrupt();
    }

    public void registerCommand(final Command command) {
        this.commandHandler.commands().add(command);
    }

}
