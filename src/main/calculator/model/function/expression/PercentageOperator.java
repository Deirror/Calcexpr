package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public final class PercentageOperator
        extends BinaryOperation {
    public PercentageOperator(MathExpression leftMathExpression, MathExpression rightMathExpression) {
        super(leftMathExpression, rightMathExpression);
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return leftMathExpression.evaluate(mathInterpreter).remainder(rightMathExpression.evaluate(mathInterpreter));
    }
}
