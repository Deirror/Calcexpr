import calculator.controller.Controller;

import calculator.model.database.FunctionDatabase;
import calculator.view.ConsoleDisplay;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                FunctionDatabase.getInstance().save();
            } catch (IOException e) {
                ConsoleDisplay display = new ConsoleDisplay();
                display.printError("Unable to save function database");
            }
        }));
        Controller controller = new Controller(new ConsoleDisplay());
        controller.start();
    }
}
