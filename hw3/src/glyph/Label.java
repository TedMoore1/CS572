package glyph;

import window.Window;
import util.Bounds;

/**
 *  Label is the AbstractProduct class of the AbstractFactory Design Pattern.
 */
public abstract class Label extends Embellishment {
    public Label(Window w) {
        super(new Row(w), w);
    }
}
