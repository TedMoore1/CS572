package command;

import window.Window;

// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype
public class DecrementFontSizeCommand extends FontCommand {

    public DecrementFontSizeCommand(Window window) { super(window); }

    @Override
    public void execute() {
        prevSize = window.getFontSize();
        window.setFontSize(prevSize - 1);
        window.repaint();
    }

    @Override
    public Command clone() { return new DecrementFontSizeCommand(window); }
}