package window;

/**
 * SwingWindowFactory uses Singleton, AbstractFactory, and FactoryMethod Design patterns.
 */
class SwingWindowFactory extends WindowFactory{
    private static SwingWindowFactory uniqueInstance;

    private SwingWindowFactory(){}

    public static SwingWindowFactory instance(){
        if (uniqueInstance == null){
            uniqueInstance = new SwingWindowFactory();
        }
        return uniqueInstance;
    }

    @Override
    protected WindowImp windowFactoryMethod(String title, Window w) {
        return new SwingWindow(title,w);
    }
}