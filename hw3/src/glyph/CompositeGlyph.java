package glyph;

import util.Bounds;
import util.Point;
import window.Window;

import java.util.ArrayList;

/**
 *  The CompositeGlyph class mirrors the Composite class of the Composite Design Pattern
 */
public abstract class CompositeGlyph extends Glyph {
    private ArrayList<Glyph> children;

    public CompositeGlyph() {
        this.setBounds(new Bounds(new Point(0, 0), 0, 0));
        children = new ArrayList<>();
    }

    // ChainOfResponsibility(223): propagate click down the containment hierarchy
    @Override
    public boolean handleClick(int x, int y) {
        int i = 0;
        Glyph child = child(i);
        while (child != null) {
            if (child.intersects(new Point(x, y)) && child.handleClick(x, y))
                return true;          // chain stops when a handler claims the click
            child = child(++i);
        }
        return false;
    }

    @Override
    public void draw(Window window) {
        for (Glyph glyph : children) {
            glyph.draw(window);
        }
    }

    @Override
    public void insert(Glyph glyph, int position) {
        glyph.setParent(this);
        children.add(position, glyph);
    }

    @Override
    public void insert(Glyph glyph) {
        glyph.setParent(this);
        children.add(glyph);
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
        this.composeRoot();
    }

    @Override
    public Glyph child(int position) {
        if (position < children.size()) {
            return children.get(position);
        } else {
            return null;
        }
    }

}