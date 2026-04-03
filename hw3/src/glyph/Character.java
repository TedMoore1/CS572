package glyph;

import util.Bounds;
import util.Point;
import window.Window;

/**
 *  Character is the concrete Leaf class of the Composite Design Pattern
 */
public class Character extends Glyph {
    private char c;

    public Character(char c) {
        this.c = c;
        this.setBounds(new Bounds(new Point(0,0),0,0));
    }

    @Override
    public void draw(Window window){
        window.drawCharacter(this.c,this.getBounds().getPoint().getX(),
                                    this.getBounds().getPoint().getY());
    }

    @Override
    public void setSize(Window window) {
        this.setSize(window.charWidth(c),window.charHeight(c));
    }

    public String toString() {
        return String.valueOf(this.c);
    }
}
