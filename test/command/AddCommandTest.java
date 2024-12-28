package command;

import main.calculator.model.command.AddCommand;
import main.calculator.model.exception.InvalidExpressionException;
import main.calculator.model.exception.InvalidFunctionException;
import main.calculator.model.function.Function;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddCommandTest {
    @Test
    void testMissingHInId() {
        String longFunction = "f(a,b,c,d,e,f,)=(((((a)^(b))/(c))*((d)%(!(e)))+((f)-(h)))";
        InvalidFunctionException exception = assertThrows(
                InvalidFunctionException.class,
                () -> Function.of(longFunction)
        );
        assertEquals("Invalid identification: " + longFunction, exception.getMessage());
    }
    @Test
    void testMissingClosingBracket() {
        String longFunction = "f(a,b,c,d,e,f,h)=(((((a)^(b))/(c))*((d)%(!(e)))+((f)-(h))";
        InvalidExpressionException exception = assertThrows(
                InvalidExpressionException.class,
                () -> Function.of(longFunction)
        );
        assertEquals("Invalid expression: " + longFunction.split("=")[1], exception.getMessage());
    }
}
