package glyph;

import window.Window;
import command.Command;
import command.CommandHistory;
import window.Window;

/**
 *  Button is the AbstractProduct class of the AbstractFactory Design Pattern.
 */
public abstract class Button extends Embellishment {
    private Command command; // prototype command; copyd on each click

    public Button(Window w) {
        super(new Row(w), w);
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() { return command; }

    // ChainOfResponsibility(223): ConcreteHandler — claims click, stops propagation
    @Override
    public boolean handleClick(int x, int y) {
        if (command != null) {
            // Prototype(117): copy the prototype so each execution is independent
            CommandHistory.instance().execute(command.copy());
            return true; // click handled; chain stops here
        }
        return false;
    }
}
