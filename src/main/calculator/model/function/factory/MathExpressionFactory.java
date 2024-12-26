package main.calculator.model.function.factory;

import main.calculator.model.exception.InvalidExpressionException;
import main.calculator.model.function.expression.*;

public interface MathExpressionFactory {
    static MathExpression createMathExpression(String expression) {
        expression = expression.substring(1, expression.length() - 1);
        if (expression.length() == 1) {
            return new Variable(expression.charAt(0));
        }
        int bracketCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == Operators.OPENING_BRACKET) {
                bracketCount++;
            } else if (expression.charAt(i) == Operators.CLOSING_BRACKET) {
                bracketCount--;
            } else if (bracketCount == 0) {
                final String leftSubstring = expression.substring(0, i);
                final String rightSubstring = expression.substring(i + 1);
                switch (expression.charAt(i)) {
                    case Operators.OPPOSITE -> {
                        return new OppositeOperator(createMathExpression(rightSubstring));
                    }
                    case Operators.PLUS -> {
                        return new PlusOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                    case Operators.MINUS -> {
                        return new MinusOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                    case Operators.MULTIPLY -> {
                        return new MultiplyOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                    case Operators.DIVIDE -> {
                        return new DivideOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                    case Operators.POWER -> {
                        return new PowerOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                    case Operators.PERCENTAGE -> {
                        return new PercentageOperator(createMathExpression(leftSubstring), createMathExpression(rightSubstring));
                    }
                }
            }
        }
        throw new InvalidExpressionException("Invalid expression: ");
    }
}
