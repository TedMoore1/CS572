package widget;

import glyph.Label;
import util.Bounds;
import window.Window;

/**
 *  GreenLabel is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class GreenLabel extends Label {

    GreenLabel(Window w) {
        super(w);
    }

    @Override
    public void draw(Window window) {
        Bounds b = this.getBounds();
        window.drawLabel(b.getPoint().getX(), b.getPoint().getY(),
                b.getWidth(), b.getHeight(), "Green");
        // To draw text on top of rectangle
        super.draw(window);
    }
}
