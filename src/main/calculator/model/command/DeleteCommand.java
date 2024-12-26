package main.calculator.model.command;

import main.calculator.model.database.FunctionDatabase;
import main.calculator.model.exception.InvalidCommandException;

import java.io.IOException;
import java.util.List;

public final class DeleteCommand
        extends Command{
    @Override
    public void execute(List<String> commandLineParts)
            throws IOException {
        if(commandLineParts.size() == 2) {
            FunctionDatabase functionDatabase = FunctionDatabase.getInstance();
            functionDatabase.delete(commandLineParts.get(1));
        } else {
            throw new InvalidCommandException("Invalid use of command delete");
        }
    }
}
