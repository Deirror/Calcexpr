package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DivideOperator
        extends BinaryOperation {
    public DivideOperator(MathExpression leftMathExpression, MathExpression rightMathExpression) {
        super(leftMathExpression, rightMathExpression);
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return leftMathExpression.evaluate(mathInterpreter).divide(rightMathExpression.evaluate(mathInterpreter),2, RoundingMode.HALF_UP);
    }
}
