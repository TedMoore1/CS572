package command;

import window.Window;

// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype
public class SetFontSizeCommand extends FontCommand {
    private final int targetSize;

    public SetFontSizeCommand(int targetSize, Window window) {
        super(window);
        this.targetSize = targetSize;
    }

    @Override
    public void execute() {
        prevSize = window.getFontSize();
        window.setFontSize(targetSize);
        window.repaint();
    }

    @Override
    public Command copy() { return new SetFontSizeCommand(targetSize,window); }
}