package widget;

import glyph.Button;
import glyph.Label;
import window.Window;

/**
 *  GreenWidgetFactory is the ConcreteFactory class of the AbstractFactory Design Pattern.
 *  Acts as ConcreteCreator as it implements the button/labelFactoryMethod (FactoryMethod)
 *  of the FactoryMethod Design Pattern.
 *  Also used in Singleton pattern with its package private constructor.
 */
class GreenWidgetFactory extends WidgetFactory {
    private static GreenWidgetFactory uniqueInstance;

    private GreenWidgetFactory() {}

    public static GreenWidgetFactory instance(){
        if(uniqueInstance == null){
            uniqueInstance = new GreenWidgetFactory();
        }
        return uniqueInstance;
    }

    @Override
    protected Button buttonFactoryMethod(Window w) {
        return new GreenButton(w);
    }

    @Override
    protected Label labelFactoryMethod(Window w) {
        return new GreenLabel(w);
    }
}