package main.calculator.model.function.expression;

import main.calculator.model.exception.InvalidCharacterException;
import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public record Variable(char letter)
        implements MathExpression {
    public Variable {
        if(!Character.isLetter(letter)) {
            throw new InvalidCharacterException("Is not a letter");
        }
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return mathInterpreter.getValue(letter);
    }
}
