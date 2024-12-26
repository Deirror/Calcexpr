package main.calculator.model.function.expression;

public sealed abstract class BinaryOperation
        implements MathExpression
        permits PlusOperator, DivideOperator, MultiplyOperator, MinusOperator, PowerOperator, PercentageOperator {
    protected MathExpression leftMathExpression;
    protected MathExpression rightMathExpression;

    public BinaryOperation(MathExpression leftMathExpression, MathExpression rightMathExpression) {
        this.leftMathExpression = leftMathExpression;
        this.rightMathExpression = rightMathExpression;
    }
}
