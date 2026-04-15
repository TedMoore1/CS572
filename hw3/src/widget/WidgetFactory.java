package widget;

import glyph.Button;
import glyph.Label;
import window.Window;


/**
 *  WidgetFactory is the AbstractFactory class of the AbstractFactory Design Pattern.
 *  Also acts as Creator of the FactoryMethod Design Pattern
 *      -createButton/Label (Create) and button/labelFactoryMethod (FactoryMethod).
 *  Is Singleton aswell, uses instance to return one and only WidgetFactory.
 */
public abstract class WidgetFactory {
    private static WidgetFactory uniqueInstance;

    public static WidgetFactory instance(){
        if (uniqueInstance == null){
            String s = System.getenv("LexiWidget");
            if (s != null && s.equals("Green")) {
                uniqueInstance = GreenWidgetFactory.instance();
            } else {
                uniqueInstance = RedWidgetFactory.instance();
            }
        }
        return uniqueInstance;

    }

    public final Button createButton(Window w) {
        return buttonFactoryMethod(w);
    }

    public final Label createLabel(Window w) {
        return labelFactoryMethod(w);
    }

    protected abstract Button buttonFactoryMethod(Window w);
    protected abstract Label  labelFactoryMethod(Window w);
}