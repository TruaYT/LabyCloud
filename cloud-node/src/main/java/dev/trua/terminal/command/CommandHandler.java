package dev.trua.terminal.command;

import dev.trua.terminal.TerminalLogger;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Accessors(fluent = true)
public final class CommandHandler {
    private final List<Command> commands;

    public CommandHandler() {
        this.commands = new ArrayList<>();
    }

    public void execute(String line, String[] args) {
        var command = this.commands.stream()
                .filter(it -> it.command().equalsIgnoreCase(line) || it.alias().contains(line.toLowerCase()))
                .findFirst()
                .orElse(null);

        if (command == null) {
            TerminalLogger.error("This command does not exists!");
            return;
        }
        command.execute(args);
    }

}
