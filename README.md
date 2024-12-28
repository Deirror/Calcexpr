# Calcexpr

![calcexpr](https://github.com/user-attachments/assets/1357c865-dcd2-4c1c-9fb8-880faa92f57a)

Description:
-

The aim of the project is to create a convinient way, using CLI, to write plain mathematical functions, save them in a file, read them from a file and solve them by passing arguments(these functions are just like templates).

All Commands:
-

| Command | Description |
|---|---|
| `help {the other command}` | Shows brief important notes about the functional commands of the program |
| `exit` |  Terminates the program and saves all made changes |
| `show {all, <function id>}` | Based on the second argument, the command shows all functions in the database and their *IDs* |
| `add <function>` | Adds a function to the database and the syntax is *f(elements)=(expression)*, where *f* can be any letter, the *elements* are also letters, more about the *expression* below |
| `delete <function id>` | Deletes a function based on an *ID* |
| `solve <function id> <argumnets>`| Based on an *ID*, the corresponding function is solved with the passed arguments and the syntax is *ID f(arguments)*, where *ID* is found by typing command `show all`, f **must** match the function name and *arguments* are just numbers |
