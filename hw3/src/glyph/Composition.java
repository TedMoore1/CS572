package glyph;

import compositior.Compositor;
import compositior.SimpleCompositor;
import util.Bounds;
import window.Window;

/**
 *  The Composition class represents the Context class of the Strategy Design Pattern,
 *  as well as being a Composite
 */
public abstract class Composition extends CompositeGlyph{
    protected Compositor compositor;

    public Composition(Window w){
        super();
        this.compositor= new SimpleCompositor(w);
    }

    @Override
    public void insert(Glyph glyph, int position) {
        //glyph.setParent(this);
        super.insert(glyph, position);
        this.composeRoot();
    }

    @Override
    public void compose(){
        this.compositor.setComposition(this);
        this.compositor.compose();
    }

    @Override
    public void setSize(Window window){this.setSize(0,0);}
}
