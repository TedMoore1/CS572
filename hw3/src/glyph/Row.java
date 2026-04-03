package glyph;

import window.Window;
import util.Bounds;

/**
 *  Row is a concrete Composite class of the Composite Design Pattern,
 *  while also inheriting from Context
 */
public class Row extends Composition {
    public Row(Window w){
        super(w);
    }

    public Row(String string, Window window) {
        super(window);
        try {
            for (int i = 0; i < string.length(); i++)
                insert(new Character(string.charAt(i)),i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void setSize(Bounds cursor, Bounds child) {
        this.setSize(this.getBounds().getWidth()+child.getWidth(), Math.max(this.getBounds().getHeight(),child.getHeight()));
        cursor.setPoint(cursor.getPoint().getX()+child.getWidth(),cursor.getPoint().getY());
    }
}
