package glyph;

import window.Window;
import util.Bounds;

/**
 *  ScrollBar mirrors the ConcreteDecorator class of the Decorator Design Pattern
 */
public class ScrollBar extends Embellishment {
    private int scrollBarWidth;

    public ScrollBar(Glyph child, Window w, int scrollBarWidth) {
        super(child, w);
        this.scrollBarWidth = scrollBarWidth;
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
        Bounds b = this.getChild().getBounds();
        window.addScrollBar(b.getPoint().getX() + b.getWidth(), b.getPoint().getY(),
                            scrollBarWidth, b.getHeight()
        );
    }

    @Override
    public void setSize(Bounds cursor, Bounds child) {
        this.setSize(child.getWidth()+scrollBarWidth, child.getHeight());
        cursor.setPoint(cursor.getPoint().getX(),cursor.getPoint().getY()+child.getHeight());
    }

}