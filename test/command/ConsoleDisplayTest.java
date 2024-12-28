package command;

import main.calculator.controller.Controller;
import main.calculator.view.ConsoleDisplay;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsoleDisplayTest {
    @Test
    void testConsoleDisplay() {
        ConsoleDisplay mockConsoleDisplay = mock(ConsoleDisplay.class);
        when(mockConsoleDisplay.getCommandLine()).thenReturn("Mock check!");
        String mockString = mockConsoleDisplay.getCommandLine();
        assertEquals("Mock check!", mockString);
    }
}
