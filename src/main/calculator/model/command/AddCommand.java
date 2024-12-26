package main.calculator.model.command;

import main.calculator.model.database.FunctionDatabase;
import main.calculator.model.exception.InvalidCommandException;
import main.calculator.model.function.Function;

import java.io.IOException;
import java.util.List;

public final class AddCommand
        extends Command {
    @Override
    public void execute(List<String> commandLineParts)
            throws IOException {
        if(commandLineParts.size() == 2) {
            Function function = Function.of(commandLineParts.get(1));
            FunctionDatabase functionDatabase = FunctionDatabase.getInstance();
            functionDatabase.add(function);
        } else {
            throw new InvalidCommandException("Invalid use of command add");
        }
    }
}
