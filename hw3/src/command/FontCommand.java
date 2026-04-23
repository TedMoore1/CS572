package command;

import window.Window;

// Command(233): ConcreteCommand (abstract base for font commands)
// Prototype(117): ConcretePrototype (abstract base)
public abstract class FontCommand implements Command {
    protected Window window;
    protected int prevSize;

    public FontCommand(Window window) {
        this.window = window;
    }

    @Override
    public boolean isReversible() { return true; }

    @Override
    public void unexecute() {
        window.setFontSize(prevSize);
        window.repaint();
    }
}