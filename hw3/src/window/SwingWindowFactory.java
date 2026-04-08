package window;

public class SwingWindowFactory extends WindowFactory{
    SwingWindowFactory(){}


    @Override
    protected WindowImp windowFactoryMethod(String title, Window w) {
        return new SwingWindow(title,w);
    }
}
