package glyph;

import util.Bounds;
import util.Point;
import window.Window;

/**
 *  Rectangle is the concrete Leaf class of the Composite Design Pattern
 */
public class Rectangle extends Glyph {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.setBounds(new Bounds(new Point(0,0),0,0));
    }

    public void setSize(Window window){
        this.setSize(width,height);
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.getBounds().getPoint().getX(),this.getBounds().getPoint().getY(),
                            this.getBounds().getWidth(),this.getBounds().getHeight());
    }
}
