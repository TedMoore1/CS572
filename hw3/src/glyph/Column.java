package glyph;

import compositior.Compositor;
import util.Bounds;
import window.Window;

/**
 *  Column is a concrete Composite class of the Composite Design Pattern,
 *  while also inheriting from Context
 */
public class Column extends Composition {

    public Column(Window w) {
        super(w);
    }

    public Column(String[] strings, Window window) {
        super(window);
        try {
            for (int i = 0; i < strings.length; i++)
                insert(new Row(strings[i], window),i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void setSize(Bounds cursor, Bounds child) {
        this.setSize(Math.max(this.getBounds().getWidth(), child.getWidth()), this.getBounds().getHeight() + child.getHeight());
        cursor.setPoint(cursor.getPoint().getX(),cursor.getPoint().getY()+child.getHeight());
    }
}
