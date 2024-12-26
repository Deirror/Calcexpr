package main.calculator.model.command;

import java.util.Map;
import java.util.TreeMap;

public final class CommandHelpInfo {
    public static final TreeMap<String, String> commandHelpInfo = new TreeMap<>(Map.of(
            "exit", "Terminates the program and save the made changes.",
            "add", "Adds function to the list -> syntax: add f(x,...)=(!(x)...), where f and x can be any letter,...-> other arguments.",
            "delete", "Deletes function based on an id from the list. Cannot undo changes",
            "show", "Shows all functions in the list -> syntax show {ID, \"all\"}",
            "solve", "Solves a function based on an id from the list. -> syntax: solve ID f({args}), where args are numbers."
    ));

    private CommandHelpInfo() {}
}
