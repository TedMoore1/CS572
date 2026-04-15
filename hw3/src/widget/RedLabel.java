package widget;

import glyph.Label;
import util.Bounds;
import window.Window;

/**
 *  RedLabel is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class RedLabel extends Label {

    RedLabel(Window w) {
        super(w);
    }

    @Override
    public void draw(Window window) {
        Bounds b = this.getBounds();
        window.drawLabel(b.getPoint().getX(), b.getPoint().getY(),
                b.getWidth(), b.getHeight(), "Red");
        // To draw text on top of rectangle
        super.draw(window);
    }
}
