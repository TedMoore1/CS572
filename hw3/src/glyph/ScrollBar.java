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
    public void setPosition(Bounds bounds) {
        super.setPosition(bounds);
        // Child start at same position
        this.getChild().getBounds().setPoint(
                bounds.getPoint().getX(),
                bounds.getPoint().getY()
        );
    }

    @Override
    public void compose() {
        // Reset child
        this.getChild().setSize(0, 0);
        // Child bounds match
        this.getChild().getBounds().setPoint(
                this.getBounds().getPoint().getX(),
                this.getBounds().getPoint().getY()
        );
        super.compose();
        // ScrollBar's bounds are child width plus scrollbar width
        this.setSize(
                this.getChild().getBounds().getWidth() + scrollBarWidth,
                this.getChild().getBounds().getHeight()
        );
    }
}