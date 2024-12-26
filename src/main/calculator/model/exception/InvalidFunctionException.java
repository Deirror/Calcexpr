package main.calculator.model.exception;

public final class InvalidFunctionException
        extends RuntimeException {
    public InvalidFunctionException(String message) {
        super(message);
    }
}
