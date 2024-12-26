package main.calculator.model.command.factory;

import main.calculator.model.command.*;

public interface CommandFactory {
    static Command of(CommandVariables commandVariable) {
        return switch (commandVariable) {
            case ADD ->  new AddCommand();
            case EXIT -> new ExitCommand();
            case SOLVE -> new SolveCommand();
            case DELETE -> new DeleteCommand();
            case HELP -> new HelpCommand();
            case SHOW -> new ShowCommand();
        };
    }
}
