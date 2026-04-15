package widget;

import glyph.Button;
import glyph.Label;
import window.Window;

/**
 *  RedWidgetFactory is the ConcreteFactory class of the AbstractFactory Design Pattern.
 *  Acts as ConcreteCreator as it implements the button/labelFactoryMethod (FactoryMethod)
 *  of the FactoryMethod Design Pattern.
 *  Also used in Singleton pattern with its package private constructor.
 */
class RedWidgetFactory extends WidgetFactory {
    private static RedWidgetFactory uniqueInstance;

    private RedWidgetFactory() {}

    public static RedWidgetFactory instance(){
        if(uniqueInstance == null){
            uniqueInstance = new RedWidgetFactory();
        }
        return uniqueInstance;
    }

    @Override
    protected Button buttonFactoryMethod(Window w) {
        return new RedButton(w);
    }

    @Override
    protected Label labelFactoryMethod(Window w) {
        return new RedLabel(w);
    }
}