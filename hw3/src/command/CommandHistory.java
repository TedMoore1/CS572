package command;

// Command(233): supports undo/redo via stack + index
// Singleton(127): one history for the whole application
import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private static CommandHistory uniqueInstance;

    private final List<Command> history = new ArrayList<>();
    private int current = -1; // index into history stack

    private CommandHistory() {}

    public static CommandHistory instance() {
        if (uniqueInstance == null) uniqueInstance = new CommandHistory();
        return uniqueInstance;
    }

    public void execute(Command command) {
        command.execute();
        if (command.isReversible()) {
            // Trim any redoable future when a new command branches history
            while (history.size() > current + 1) {
                history.removeLast();
            }
            history.add(command);
            current++;
        }
    }

    public void undo() {
        if (current >= 0) {
            history.get(current).unexecute();
            current--;
        }
    }

    public void redo() {
        if (current < history.size() - 1) {
            current++;
            history.get(current).execute();
        }
    }
}