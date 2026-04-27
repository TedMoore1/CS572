import command.*;
import glyph.*;
import glyph.Character;
import widget.WidgetFactory;
import window.ApplicationWindow;

public class Lexi {
    public static void main(String[] args){
        //SwingWindow w = new SwingWindow("Lexi");
        KeyMap km = new KeyMap();
        ApplicationWindow w = new ApplicationWindow("Lexi");
        km.put('i', new IncrementFontSizeCommand(w));
        km.put('d', new DecrementFontSizeCommand(w));
        km.put('u', new UndoCommand());
        km.put('r', new RedoCommand());
        w.setKeyMap(km);

        //Columns and Rows
        Glyph c1 = new Column(new String[]{"X","","Z"},w);
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


        //Creating label and button
        WidgetFactory widgetFactory = WidgetFactory.instance();
        Button button = widgetFactory.createButton(w);
        Label label = widgetFactory.createLabel(w);


        label.insert(new Row("pq",w));
        button.insert(new Row("PQ",w));

        c1.insert(label,1);


        //Building up Rows and Columns
        r1.insert(a,0);
        r1.insert(rectangle1,1);
        r1.insert(c1,2);
        r1.insert(b,3);
        r2.insert(x1,0);
        r2.insert(rectangle2,1);
        r2.insert(y1,2);

        c2.insert(r1,0);
        c2.insert(r2,1);

        //add button
        c2.insert(button,2);


        //New clickable buttons
        Button inc = widgetFactory.createButton(w);
        inc.insert(new Character('+'));
        inc.setCommand(new IncrementFontSizeCommand(w));
        Button dec = widgetFactory.createButton(w);
        dec.insert(new Character('-'));
        dec.setCommand(new DecrementFontSizeCommand(w));
        Button set14 = widgetFactory.createButton(w);
        set14.insert(new Row("14",w));
        set14.setCommand(new SetFontSizeCommand(14,w));
        Button set20 = widgetFactory.createButton(w);
        set20.insert(new Row("20",w));
        set20.setCommand(new SetFontSizeCommand(20,w));

        Glyph r3 = new Row(w);
        r3.insert(inc);
        r3.insert(dec);
        r3.insert(set14);
        r3.insert(set20);
        c2.insert(r3);


        //Border + Scroll Bar
        Embellishment scroll = new ScrollBar(c2,w,10);
        Embellishment border = new Border(scroll,w,5);
        //border.insert(new Row("Scroller too!",w));

        w.setContents(border);
    }
}
