package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public final class PowerOperator
        extends BinaryOperation {
    public PowerOperator(MathExpression leftMathExpression, MathExpression rightMathExpression) {
        super(leftMathExpression, rightMathExpression);
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return leftMathExpression.evaluate(mathInterpreter).pow(rightMathExpression.evaluate(mathInterpreter).intValue());
    }
}
