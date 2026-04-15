package widget;

import glyph.Button;
import util.Bounds;
import window.Window;

/**
 *  GreenButton is the ConcreteProduct class of the AbstractFactory Design Pattern
 */
class GreenButton extends Button {

    GreenButton(Window w) {
        super(w);
    }

    @Override
    public void draw(Window window) {
        Bounds b = this.getBounds();
        window.drawButton(b.getPoint().getX(), b.getPoint().getY(),
                b.getWidth(), b.getHeight(), "Green");
        // To draw text on top of rectangle
        super.draw(window);
    }
}
