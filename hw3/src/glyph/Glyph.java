package glyph;

import util.Bounds;
import util.Point;
import window.Window;

/**
 *  Glyph is the Component class of the Composite Design Pattern
 */
public abstract class  Glyph {
    private Glyph parent;
    private Bounds bounds;



    //abstract methods
    abstract public void draw(Window window);
    //default behavior
    // ChainOfResponsibility(223): Handler — default passes responsibility upward (returns false)
    public boolean handleClick(int x, int y) { return false; }

    // Default intersection test using bounds
    public boolean intersects(Point point) {
        Bounds b = getBounds();
        if (b == null) return false;
        return point.getX() >= b.getPoint().getX()
                && point.getX() <  b.getPoint().getX() + b.getWidth()
                && point.getY() >= b.getPoint().getY()
                && point.getY() <  b.getPoint().getY() + b.getHeight();
    }

    public void insert(Glyph glyph, int position){throw new UnsupportedOperationException("This glyph cannot have children.");}
    public void insert(Glyph glyph){throw new UnsupportedOperationException("This glyph cannot have children.");}
    public void remove(Glyph glyph){throw new UnsupportedOperationException("This glyph cannot have children.");}
    public Glyph child(int position){throw new UnsupportedOperationException("This glyph cannot have children.");}
    public Glyph getParent(){return parent;}
    public void setParent(Glyph parent){this.parent = parent;}
    public void setBounds(Bounds bounds){this.bounds=bounds;}
    public Bounds getBounds(){return bounds;}

    //public void adjustBounds()?
    public void setPosition(Bounds bounds){this.bounds.setPoint(bounds.getPoint().getX(),bounds.getPoint().getY());}
    public void setSize(int width, int height){this.bounds.setWidth(width);this.bounds.setHeight(height);}
    public void setSize(Bounds cursor, Bounds child){throw new UnsupportedOperationException("This glyph cannot have children.");}
    public void setSize(Window window){}


    public void compose(){/*Default do nothing*/}
    public void composeRoot(){
        Glyph root = this;
        while(root.getParent()!=null){
            root=root.getParent();
        }
        root.compose();
    }
}
