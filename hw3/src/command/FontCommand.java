package command;

import window.Window;

// Command(233): ConcreteCommand (abstract class)
// Prototype(117): ConcretePrototype (abstract base)
public abstract class FontCommand implements Command {
    private Window window;
    private int prevSize;

    protected FontCommand(Window window) { this.window = window; }
    protected Window getWindow()       { return window; }
    protected int  getPrevSize()       { return prevSize; }
    protected void setPrevSize(int n)  { this.prevSize = n; }

    @Override
    public boolean isReversible() { return true; }

    @Override
    public void unexecute() {
        window.setFontSize(prevSize);
        window.repaint();
    }
}