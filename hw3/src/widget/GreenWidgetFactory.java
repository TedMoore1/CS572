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
public class GreenWidgetFactory extends WidgetFactory {

    GreenWidgetFactory() {}

    @Override
    protected Button buttonFactoryMethod(Window w) {
        return new GreenButton(w);
    }

    @Override
    protected Label labelFactoryMethod(Window w) {
        return new GreenLabel(w);
    }
}