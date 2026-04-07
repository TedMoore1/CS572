package widget;

import glyph.Button;
import window.Window;

/**
 *  GreenButton is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class GreenButton extends Button {

    GreenButton(Window w) {
        super(w);
    }

    @Override
    protected String color() {
        return "Green";
    }
}
