package window;

public class AwtWindowFactory extends WindowFactory{
    AwtWindowFactory(){}

    @Override
    protected WindowImp windowFactoryMethod(String title, Window w) {
        return new AwtWindow(title,w);
    }
}
