package main.calculator.model.function.expression;

public sealed abstract class UnaryOperation
        implements MathExpression
        permits OppositeOperator {
    protected MathExpression mathExpression;

    public UnaryOperation(MathExpression mathExpression) {
        this.mathExpression = mathExpression;
    }
}
