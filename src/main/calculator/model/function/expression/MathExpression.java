package main.calculator.model.function.expression;

import main.calculator.model.function.interpreter.MathInterpreter;

import java.math.BigDecimal;

public sealed interface MathExpression
        permits Variable, UnaryOperation, BinaryOperation {
    BigDecimal evaluate(MathInterpreter mathInterpreter);
}