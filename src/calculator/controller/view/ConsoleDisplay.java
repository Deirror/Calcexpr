package calculator.view;

import calculator.model.command.CommandHelpInfo;
import calculator.model.command.CommandVariables;
import calculator.model.database.FunctionDatabase;
import calculator.model.exception.InvalidCommandException;
import calculator.model.function.Function;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public final class ConsoleDisplay {
    private final Scanner scanner;

    public ConsoleDisplay() {
        scanner = new Scanner(System.in);
    }

    private void printLogo() {
        System.out.printf("%s\n", ConsoleVariables.LOGO);
    }

    private void printPrompt() {
        System.out.printf("%s", ConsoleVariables.PROMPT);
    }

    public void printStartUpInterface() {
        printLogo();
    }

    public String getCommandLine() {
        printPrompt();
        return scanner.nextLine();
    }

    public void printHelp(CommandVariables commandVariable) {
        if(commandVariable == null) {
            CommandHelpInfo.commandHelpInfo.forEach((key, value) -> System.out.printf("%-10s%s\n",key,value));
        } else {
            if(commandVariable != CommandVariables.HELP) {
                String command = commandVariable.getCommand().toLowerCase();
                System.out.printf("%-10s%s\n", command, CommandHelpInfo.commandHelpInfo.get(command));
            } else {
                throw new InvalidCommandException("Help is just help bruh.");
            }
        }
    }

    public void printFunction(String key, Function function) {
        System.out.printf("%-10s%s\n",key, function.toString());
    }

    public void printResult(String function, BigDecimal result) {
        printPrompt();
        System.out.println(function + "=" + result.toString());
    }

    public void printError(String message) {
        System.out.printf("%s" + message + '\n', ConsoleVariables.DEIRROR);
    }
}
