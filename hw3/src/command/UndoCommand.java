package command;

// Command(233): ConcreteCommand
public class UndoCommand implements Command {

    @Override
    public void execute()   { CommandHistory.instance().undo(); }

    @Override
    public void unexecute() { CommandHistory.instance().redo(); }

    @Override
    public boolean isReversible() { return false; } // Never logged to history

    @Override
    public Command clone() { return new UndoCommand(); }
}