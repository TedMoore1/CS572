package compositior;

import glyph.Composition;
import glyph.Glyph;
import util.Bounds;
import util.Point;
import window.Window;

/**
 *  SimpleCompositor is a concrete Strategy class of the Strategy Design Pattern
 */
public class SimpleCompositor implements Compositor {
    private Composition c;
    private Window w;

    public SimpleCompositor(Window w) {
        this.w = w;
    }

    @Override
    public void setComposition(Composition composition) {
        this.c = composition;
    }

    @Override
    public void compose() {
        // create cursor based on parent
        Bounds cursor = new Bounds(new Point(c.getBounds().getPoint().getX(), c.getBounds().getPoint().getY()),
                                    c.getBounds().getWidth(), c.getBounds().getHeight());
        int i = 0;
        for (Glyph child = c.child(i); child!=null; i++, child = c.child(i)) {
            // ask (leaf) child to set size, based on window
            child.setSize(w);

            // ask child to set position, based on cursor
            child.setPosition(cursor);

            // ask child to compose itself, recursively
            child.compose();

            // ask parent to adjust itself and cursor, based on child
            c.setSize(cursor, child.getBounds());
        }
        // ask parent to adjust itself, based on cursor
    }

}
