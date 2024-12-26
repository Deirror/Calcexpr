package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public final class PlusOperator
        extends BinaryOperation {
    public PlusOperator(MathExpression leftMathExpression, MathExpression rightMathExpression) {
        super(leftMathExpression, rightMathExpression);
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return leftMathExpression.evaluate(mathInterpreter).add(rightMathExpression.evaluate(mathInterpreter));
    }
}
