package main.calculator.model.exception;

public final class InvalidCharacterException
        extends RuntimeException {
    public InvalidCharacterException(String message) {
        super(message);
    }
}
