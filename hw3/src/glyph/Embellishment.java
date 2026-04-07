package glyph;

import util.Bounds;
import window.Window;

/**
 *  Embellishment is the Decorator class of the Decorator Design Pattern
 */
public abstract class Embellishment extends Composition {
    private Glyph child;

    public Embellishment(Glyph child, Window w) {
        super(w);
        this.child=child;
        super.insert(child,0);
        this.child(0).setParent(this);
    }

    // Delegate inserts to the child
    @Override
    public void insert(Glyph glyph, int position) {
        this.child.insert(glyph, position);
    }

    @Override
    public void insert(Glyph glyph) {
        //glyph.setParent(this);
        this.child.insert(glyph);
    }

    //Delegate remove to the child
    @Override
    public void remove(Glyph glyph) {
        this.child.remove(glyph);
    }


    //Get the actual child
    public Glyph getChild() {
        return child;
    }

    @Override
    public void setSize(Bounds cursor, Bounds child) {
        this.setSize(child.getWidth(), child.getHeight());
        cursor.setPoint(cursor.getPoint().getX(),cursor.getPoint().getY()+child.getHeight());
    }


}