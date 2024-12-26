package main.calculator.model.command;

import main.calculator.model.database.FunctionDatabase;
import main.calculator.model.exception.InvalidCommandException;
import main.calculator.model.exception.InvalidFunctionException;
import main.calculator.model.function.Function;
import main.calculator.model.function.interpreter.MathCharacterValidator;
import main.calculator.model.function.interpreter.MathInterpreter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SolveCommand
        extends Command {
    @Override
    public void execute(List<String> commandLineParts)
            throws IOException {
        if(commandLineParts.size() == 3) {
            FunctionDatabase functionDatabase = FunctionDatabase.getInstance();
            Function function = functionDatabase.get(commandLineParts.get(1));
            String arguments = commandLineParts.get(2);
            Pattern pattern = Pattern.compile("^[a-zA-Z]\\((\\d+(?:\\.\\d+)?(?:,\\d+(?:\\.\\d+)?)*)\\)");
            Matcher matcher = pattern.matcher(arguments);
            if (matcher.find()) {
                if(!function.toString().startsWith(arguments.charAt(0) + "")) {
                    throw new InvalidFunctionException("Invalid function signature");
                }
                List<BigDecimal> numbers = new ArrayList<>();
                String[] numStrings = matcher.group(1).split(",");
                for (String num : numStrings) {
                    numbers.add(new BigDecimal(num));
                }
                if(function.getArgumentsCount() == numbers.size()) {
                    MathInterpreter mp = new MathInterpreter(new HashMap<>(), new MathCharacterValidator());
                    function.populateVariables(mp, numbers);
                    consoleDisplay.printResult(arguments, function.evaluate(mp));
                } else {
                    throw new InvalidFunctionException("Unable to parse arguments");
                }
            } else {
                throw new InvalidFunctionException("Invalid function with arguments");
            }
        } else {
            throw new InvalidCommandException("Invalid use of command solve");
        }
    }
}
