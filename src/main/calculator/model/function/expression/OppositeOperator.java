package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public final class OppositeOperator
        extends UnaryOperation {
    private static final BigDecimal MINUS_ONE = new BigDecimal("-1");

    public OppositeOperator(MathExpression mathExpression) {
        super(mathExpression);
    }

    @Override
    public BigDecimal evaluate(MathInterpreter mathInterpreter) {
        return mathExpression.evaluate(mathInterpreter).multiply(MINUS_ONE);// check
    }
}
