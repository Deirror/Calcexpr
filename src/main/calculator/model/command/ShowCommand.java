package main.calculator.model.command;

import main.calculator.model.database.FunctionDatabase;
import main.calculator.model.exception.InvalidCommandException;
import main.calculator.model.function.Function;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public final class ShowCommand
        extends Command {
    @Override
    public void execute(List<String> commandLineParts)
            throws IOException {
        if(commandLineParts.size() == 2) {
            final FunctionDatabase functionDatabase = FunctionDatabase.getInstance();
            if(functionDatabase.getFunctions().isEmpty()) {
                consoleDisplay.printError("There are no functions in the database");
                return;
            }
            if(commandLineParts.get(1).equals("all")) {
                HashMap<String, Function> functions = functionDatabase.getFunctions();
                functions.forEach(consoleDisplay::printFunction);
            } else {
                consoleDisplay.printFunction(commandLineParts.get(1), functionDatabase.get(commandLineParts.get(1)));
            }
        } else {
            throw new InvalidCommandException("Invalid use of show command");
        }
    }
}
