import glyph.*;
import glyph.Character;
import window.SwingWindow;

public class Lexi {
    public static void main(String[] args){
        SwingWindow w = new SwingWindow("Lexi");

        //Columns and Rows
        Glyph c1 = new Column(new String[]{"This is a","border demonstration."},w);
        Glyph c2 = new Column(w);
        Glyph r1 = new Row(w);
        Glyph r2 = new Row(w);

        // Characters and Rectangles
        Glyph a = new Character('a');
        Glyph b = new Character('b');
        Glyph x1 = new Character('x');
        Glyph y1 = new Character('y');
        Glyph rectangle1 = new Rectangle(10,20);
        Glyph rectangle2 = new Rectangle(20,10);

        //Border + Scroll Bar
        Embellishment scroll = new ScrollBar(c1,w,10);

        Embellishment border = new Border(scroll,w,5);
        border.insert(new Row("Scroller too!",w));


        //Building up Rows and Columns
        r1.insert(a,0);
        r1.insert(rectangle1,1);
        r1.insert(border,2);
        r1.insert(b,3);
        r2.insert(x1,0);
        r2.insert(rectangle2,1);
        r2.insert(y1,2);

        c2.insert(r1,0);
        c2.insert(r2,1);

        w.setContents(c2);
    }
}
