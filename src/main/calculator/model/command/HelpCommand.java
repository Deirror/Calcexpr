package main.calculator.model.command;

import main.calculator.model.exception.InvalidCommandException;

import java.util.List;

public final class HelpCommand
        extends Command {
    @Override
    public void execute(List<String> commandLineParts) {
        if(commandLineParts.size() == 1) {
            consoleDisplay.printHelp(null);
        } else if(commandLineParts.size() == 2) {
            consoleDisplay.printHelp(CommandVariables.valueOf(commandLineParts.get(1).toUpperCase()));
        } else {
            throw new InvalidCommandException("Too many arguments");
        }
    }
}
