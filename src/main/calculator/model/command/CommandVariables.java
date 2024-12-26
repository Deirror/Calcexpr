package main.calculator.model.command;

public enum CommandVariables {
    EXIT("exit"),
    HELP("help"),
    ADD("add"),
    SOLVE("solve"),
    DELETE("delete"),
    SHOW("show");

    private final String command;

    CommandVariables(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
