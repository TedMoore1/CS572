package glyph;

import window.Window;
import util.Bounds;

/**
 *  Button is the AbstractProduct class of the AbstractFactory Design Pattern.
 */
public abstract class Button extends Embellishment {
    public Button(Window w) {
        super(new Row(w), w);
    }
}
