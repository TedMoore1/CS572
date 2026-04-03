package glyph;

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
    public void setPosition(Bounds bounds) {
        super.setPosition(bounds);
        //Offsets child's point by the amount of border width
        this.getChild().getBounds().setPoint(
                bounds.getPoint().getX() + borderWidth,
                bounds.getPoint().getY() + borderWidth
        );
    }

    @Override
    public void compose() {
        // Reset child size
        this.getChild().setSize(0, 0);
        this.getChild().getBounds().setPoint(
                this.getBounds().getPoint().getX() + borderWidth,
                this.getBounds().getPoint().getY() + borderWidth
        );
        super.compose();
        // adds room for border
        this.setSize(
                this.getChild().getBounds().getWidth()  + 2 * borderWidth,
                this.getChild().getBounds().getHeight() + 2 * borderWidth
        );
    }
}