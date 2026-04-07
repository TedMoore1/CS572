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

    protected abstract String color();

    @Override
    public void draw(Window window) {
        Bounds b = this.getBounds();
        window.drawLabel(b.getPoint().getX(), b.getPoint().getY(),
                         b.getWidth(), b.getHeight(), color());
        super.draw(window);
    }

    @Override
    public void setPosition(Bounds bounds) {
        super.setPosition(bounds);
        this.getChild().getBounds().setPoint(bounds.getPoint().getX(),
                                             bounds.getPoint().getY());
    }
}
