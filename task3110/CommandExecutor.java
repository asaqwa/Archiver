package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();
    static {
        Command[] commands = {new ZipCreateCommand(), new ZipAddCommand(), new ZipRemoveCommand(), new ZipExtractCommand(), new ZipContentCommand(), new ExitCommand()};
        for (int i = 0; i < commands.length; i++) {
            ALL_KNOWN_COMMANDS_MAP.put(Operation.values()[i], commands[i]);
        }
    }

    private CommandExecutor() {}

    public static void execute(Operation operation) throws Exception {
        ALL_KNOWN_COMMANDS_MAP.get(operation).execute();
    }
}
