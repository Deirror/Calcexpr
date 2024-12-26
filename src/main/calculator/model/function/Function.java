package main.calculator.model.function;

import main.calculator.model.exception.InvalidExpressionException;
import main.calculator.model.exception.InvalidFunctionException;
import main.calculator.model.function.expression.MathExpression;
import main.calculator.model.function.factory.MathExpressionFactory;
import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Function {
    private final long argumentsCount;
    private final String functionIdentification;
    private final String functionExpression;
    private final MathExpression mathExpression;

    public static Function of(String stringedFunction) {
        if (!isValidFunction(stringedFunction)) {
            throw new InvalidFunctionException("Invalid identification: " + stringedFunction);
        }
        return new Function(stringedFunction);
    }

    private static boolean isValidFunction(String stringedFunction) {
        List<String> stringedFunctionParts = Arrays.stream(stringedFunction.split("=")).toList();
        if(stringedFunctionParts.size() == 2) {
            Pattern idPattern = Pattern.compile("^([a-zA-Z]+)\\(([^)]*)\\)$");
            Matcher idMatcher = idPattern.matcher(stringedFunctionParts.getFirst());
            if (idMatcher.matches()) {
                String parametersInID = idMatcher.group(2);
                String[] params = parametersInID.split("\\s*,\\s*");
                HashSet<Character> exprParams = stringedFunctionParts.get(1)
                        .chars()
                        .filter(Character::isLetter)
                        .mapToObj(c -> (char) c)
                        .collect(HashSet::new, HashSet::add, HashSet::addAll);
                if(exprParams.size() != params.length) {
                    return false;
                }
                for (String param : params) {
                    if (!stringedFunctionParts.get(1).contains(param)) {
                        return false;
                    }
                }
                return (stringedFunctionParts.get(0).matches("^[a-zA-Z]\\([a-zA-Z](?:,[a-zA-Z])*\\)$"));
            }
            return false;
        } else {
           return false;
        }
    }

    private Function(String stringedFunction) {
        String[] stringedFunctionParts = stringedFunction.split("=");
        this.functionIdentification = stringedFunctionParts[0];
        this.functionExpression = stringedFunctionParts[1];
        try {
            this.mathExpression = MathExpressionFactory.createMathExpression(functionExpression);
            this.argumentsCount = functionIdentification.
                    chars()
                    .filter(ch -> ch == ',')
                    .count() + 1;
        } catch (InvalidExpressionException e) {
            throw new InvalidExpressionException(e.getMessage() + functionExpression);
        }
    }

    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return mathExpression.evaluate(mathInterpreter);
    }

    public void populateVariables(MathInterpreter mathInterpreter, List<BigDecimal> numbers) {
        List<Character> params = this.functionIdentification.substring(1)
                .chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .toList();
        Iterator<BigDecimal> iterator = numbers.iterator();
        for(Character param : params) {
            mathInterpreter.setCharacter(param, iterator.next());
        }
    }

    public long getArgumentsCount() {
        return argumentsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return Objects.equals(functionIdentification, function.functionIdentification) &&
                Objects.equals(functionExpression, function.functionExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionIdentification, functionExpression);
    }

    @Override
    public String toString() {
        return functionIdentification + '=' + functionExpression;
    }
}
