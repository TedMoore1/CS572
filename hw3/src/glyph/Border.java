package glyph;

import util.Point;
import window.Window;
import util.Bounds;

/**
 *  Border mirrors the ConcreteDecorator class of the Decorator Design Pattern
 */
public class Border extends Embellishment {
    private int borderWidth;

    public Border(Glyph child, Window w, int borderWidth) {
        super(child, w);
        this.borderWidth = borderWidth;
        composeRoot();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
        Bounds b = this.getBounds();
        window.addBorder(b.getPoint().getX(), b.getPoint().getY(),
                     b.getPoint().getX() + b.getWidth(),b.getPoint().getY() + b.getHeight(),
                         borderWidth);
    }


    @Override
    public void setSize(Bounds cursor, Bounds child) {
        this.setSize(child.getWidth()+borderWidth*2, child.getHeight()+borderWidth*2);
        cursor.setPoint(cursor.getPoint().getX(),cursor.getPoint().getY()+child.getHeight());
    }

    @Override
    public Point getCursorStart() {
        return new Point(
                this.getBounds().getPoint().getX() + borderWidth,
                this.getBounds().getPoint().getY() + borderWidth
        );
    }
}