package command;

import window.Window;

// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype
public class IncrementFontSizeCommand extends FontCommand {

    public IncrementFontSizeCommand(Window window) { super(window); }

    @Override
    public void execute() {
        prevSize = window.getFontSize();
        window.setFontSize(prevSize + 1);
        window.repaint();
    }

    @Override
    public Command copy() { return new IncrementFontSizeCommand(window); }
}