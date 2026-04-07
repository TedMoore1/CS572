package widget;

import glyph.Button;
import window.Window;

/**
 *  RedButton is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class RedButton extends Button {

    RedButton(Window w) {
        super(w);
    }

    @Override
    protected String color() {
        return "Red";
    }
}
