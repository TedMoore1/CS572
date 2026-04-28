package command;

import window.Window;

// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype
public class DecrementFontSizeCommand extends FontCommand {

    public DecrementFontSizeCommand(Window window) { super(window); }

    @Override
    public void execute() {
        setPrevSize(getWindow().getFontSize());
        getWindow().setFontSize(getPrevSize() - 1);
        getWindow().repaint();
    }

    @Override
    public Command copy() { return new DecrementFontSizeCommand(getWindow()); }
}