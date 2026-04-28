package glyph;

import window.Window;
import command.Command;
import command.CommandHistory;
import window.Window;

/**
 *  Button is the AbstractProduct class of the AbstractFactory Design Pattern.
 *  ChainOfResponsibility(223): ConcreteHandler
 *  Prototype(117): copies the prototypes
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


    @Override
    public boolean handleClick(int x, int y) {
        if (command != null) {
            CommandHistory.instance().execute(command.copy());
            return true;
        }
        return false;
    }
}
