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

    protected abstract String color();

    @Override
    public void draw(Window window) {
        Bounds b = this.getBounds();
        window.drawButton(b.getPoint().getX(), b.getPoint().getY(),
                          b.getWidth(), b.getHeight(), color());
        // To draw tex on top of rectangle
        super.draw(window);
    }

    @Override
    public void setPosition(Bounds bounds) {
        super.setPosition(bounds);
        this.getChild().getBounds().setPoint(bounds.getPoint().getX(),
                                             bounds.getPoint().getY());
    }
}
