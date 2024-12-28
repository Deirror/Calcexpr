package command;

import main.calculator.model.function.Function;
import main.calculator.model.function.interpreter.MathCharacterValidator;
import main.calculator.model.function.interpreter.MathInterpreter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SolveCommandTest {
    @Test
    void testPythagorasCommand() {
        Function function = Function.of("c(a,b,p)=(((a)^(p))+((b)^(p)))");
        MathInterpreter mp = new MathInterpreter(new HashMap<>(), new MathCharacterValidator());
        mp.setCharacter('a',new BigDecimal(3));
        mp.setCharacter('b',new BigDecimal(4));
        mp.setCharacter('p',new BigDecimal(2));
        assertEquals(new BigDecimal(25), function.evaluate(mp), "3^2 + 4^2 = 25");
    }

}
