package widget;

import glyph.Label;
import window.Window;

/**
 *  RedLabel is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class RedLabel extends Label {

    RedLabel(Window w) {
        super(w);
    }

    @Override
    protected String color() {
        return "Red";
    }
}
