package main.calculator.model.command;

import main.calculator.model.exception.InvalidCommandException;

import java.util.List;

public final class ExitCommand
        extends Command{
    @Override
    public void execute(List<String> commandLineParts) {
        if (commandLineParts.size() == 1) {
            System.exit(0);
        } else {
            throw new InvalidCommandException("Unnecessary arguments after command");
        }
    }
}
