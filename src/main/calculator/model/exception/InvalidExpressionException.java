package main.calculator.model.exception;

public final class InvalidExpressionException
        extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}
