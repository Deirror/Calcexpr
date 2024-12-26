package main.calculator.model.exception;

public class HasSuchArgumentException
        extends RuntimeException {
    public HasSuchArgumentException(String message) {
        super(message);
    }
}
