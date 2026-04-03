package glyph;

import window.Window;

/**
 *  Embellishment is the Decorator class of the Decorator Design Pattern
 */
public abstract class Embellishment extends Composition {

    public Embellishment(Glyph child, Window w) {
        super(w);
        this.insert(child);
        this.child(0).setParent(this);
    }

    // Delegate inserts to the child
    @Override
    public void insert(Glyph glyph, int position) {
        this.child(0).insert(glyph, position);
    }

    public void insert(Glyph glyph) {
        this.child(0).insert(glyph);
    }

    //Delegate remove to the child
    @Override
    public void remove(Glyph glyph) {
        this.child(0).remove(glyph);
    }

    //Get child from the child
//    @Override
//    public Glyph child(int position) {
//        return this.child(0).child(position);
//    }

    //Get the actual child
    public Glyph getChild() {
        return child(0);
    }

    @Override
    public void draw(Window window) {
        this.child(0).draw(window);
    }

    @Override
    public void compose() {
        this.child(0).compose();
    }
}