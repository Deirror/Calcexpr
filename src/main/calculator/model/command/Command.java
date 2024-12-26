package main.calculator.model.command;

import main.calculator.view.ConsoleDisplay;

import java.io.IOException;
import java.util.List;

public sealed abstract class Command
        permits AddCommand, DeleteCommand, ExitCommand, HelpCommand, ShowCommand, SolveCommand {
    protected static final ConsoleDisplay consoleDisplay;
    static {
        consoleDisplay = new ConsoleDisplay();
    }
    public abstract void execute(List<String> commandLineParts)
            throws IOException;
}
