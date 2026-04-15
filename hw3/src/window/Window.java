package window;

import glyph.*;

/**
 * Window is the Abstraction class of the Bridge pattern.
 */
public abstract class Window {
    private WindowImp imp;
    private Glyph glyph;

    protected WindowImp getImp(){return imp;}
    protected Glyph getGlyph(){return glyph;}
    protected void setGlyph(Glyph glyph){this.glyph = glyph;}

    public Window(String title){imp =  WindowFactory.instance().createWindow(title,this);}

    // Forward to WindowImp
    public void drawCharacter(char c, int x, int y){imp.drawCharacter(c,x,y);}
    // If other subclasses are not supposed to be able to have rectangles.
    public void drawRectangle(int x, int y, int width, int height){}
    public int charWidth(char c) {return imp.charWidth(c);}
    public int charHeight(char c){return imp.charHeight(c);}
    public void addBorder(int x1, int y1, int x2, int y2, int width){imp.addBorder(x1,y1,x2,y2,width);}
    public void addScrollBar(int x, int y, int width, int height){imp.addScrollBar(x,y,width,height);}
    public void drawButton(int x, int y, int width, int height, String color){imp.drawButton(x,y,width,height,color);}
    public void drawLabel(int x, int y, int width, int height, String color){imp.drawLabel(x,y,width,height,color);}

    // Implement in subclass
    abstract public void draw();
    abstract public void setContents(Glyph glyph);
}