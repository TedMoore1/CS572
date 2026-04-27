package window;

import command.Command;
import command.CommandHistory;
import command.KeyMap;
import glyph.Glyph;

/**
 * ApplicationWindow is the ConcreteAbstraction class of the Bridge pattern.
 */
public class ApplicationWindow extends Window{
    public ApplicationWindow(String title) {super(title);}

    @Override
    public void draw() {getGlyph().draw(this);}

    @Override
    public void setContents(Glyph glyph){
        setGlyph(glyph);
        getImp().setContents();
    }

    @Override
    public void key(char c) {
        Command cmd = getKeyMap().get(c);
        if (cmd != null) {
            CommandHistory.instance().execute(cmd.copy()); // Prototype
        }
    }

    // Application Window Specific
    @Override
    public void drawRectangle(int x, int y, int width, int height) {getImp().drawRectangle(x,y,width,height);}

}
