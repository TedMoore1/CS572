package widget;

import glyph.Label;
import window.Window;

/**
 *  GreenLabel is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class GreenLabel extends Label {

    GreenLabel(Window w) {
        super(w);
    }

    @Override
    protected String color() {
        return "Green";
    }
}
