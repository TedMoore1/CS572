package command;

// Command(233): Command
// Prototype(117): Prototype
public interface Command {
    void execute();
    void unexecute();
    boolean isReversible(); // Distinguishes undo/redo commands without casting
    Command clone();
}