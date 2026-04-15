package window;

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

    // Application Window Specific
    @Override
    public void drawRectangle(int x, int y, int width, int height) {getImp().drawRectangle(x,y,width,height);}

}
