package command;

import java.util.Stack;

// Command(233): history list holder
// Singleton(127): Singleton
public class CommandHistory {
    private static CommandHistory uniqueInstance;
    private final Stack<Command> past   = new Stack<>();
    private final Stack<Command> future = new Stack<>();

    private CommandHistory() {}

    public static CommandHistory instance() {
        if (uniqueInstance == null)
            uniqueInstance = new CommandHistory();
        return uniqueInstance;
    }

    /** Execute a command and log it if reversible. */
    public void execute(Command command) {
        command.execute();
        if (command.isReversible()) {
            past.push(command);
            future.clear();
        }
    }

    public void undo() {
        if (!past.isEmpty()) {
            Command c = past.pop();
            c.unexecute();
            future.push(c);
        }
    }

    public void redo() {
        if (!future.isEmpty()) {
            Command c = future.pop();
            c.execute();
            past.push(c);
        }
    }
}