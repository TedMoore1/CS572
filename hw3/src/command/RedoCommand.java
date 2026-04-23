package command;

// Command(233): ConcreteCommand
public class RedoCommand implements Command {

    @Override
    public void execute()   { CommandHistory.instance().redo(); }

    @Override
    public void unexecute() { CommandHistory.instance().undo(); }

    @Override
    public boolean isReversible() { return false; } // Never logged to history

    @Override
    public Command clone() { return new RedoCommand(); }
}