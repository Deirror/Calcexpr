package main.calculator.controller;

import main.calculator.model.command.Command;
import main.calculator.model.command.CommandVariables;
import main.calculator.model.command.factory.CommandFactory;
import main.calculator.model.exception.*;
import main.calculator.view.ConsoleDisplay;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public final class Controller {
    private final ConsoleDisplay consoleDisplay;

    public Controller(ConsoleDisplay consoleDisplay) {
        this.consoleDisplay = consoleDisplay;
    }

    public void start() {
        consoleDisplay.printStartUpInterface();
        while (true) {
            String commandLine = consoleDisplay.getCommandLine().trim().replaceAll("\\s+", " ");
            if(commandLine.isEmpty() || commandLine.isBlank()) {
                continue;
            }
            List<String> commandLineParts = Arrays.stream(commandLine.split(" ")).toList();
            try {
                Command command = CommandFactory.of(CommandVariables.valueOf(commandLineParts.getFirst().toUpperCase()));
                command.execute(commandLineParts);
            } catch(IllegalArgumentException | NoSuchElementException exception) {
                if(exception instanceof NoSuchElementException) {
                    consoleDisplay.printError(exception.getMessage());
                } else {
                    consoleDisplay.printError("No such command exists with given arguments");
                }
            } catch(InvalidCommandException | ArithmeticException |
                    InvalidFunctionException | InvalidExpressionException |
                    InvalidCharacterException exception) {
                if(exception instanceof ArithmeticException) {
                    consoleDisplay.printError("Try other arguments which don't lead to division by zero.");
                } else {
                    consoleDisplay.printError(exception.getMessage());
                }
            } catch(IOException exception) {
                consoleDisplay.printError(exception.getMessage());
                return;
            } catch (HasSuchArgumentException exception) {
                consoleDisplay.printError(exception.getMessage());
            }
        }
    }
}
