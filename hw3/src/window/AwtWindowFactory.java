package window;

/**
 * AwtWindowFactory uses Singleton, AbstractFactory, and FactoryMethod Design patterns.
 */
class AwtWindowFactory extends WindowFactory{
    private static AwtWindowFactory uniqueInstance;

    private AwtWindowFactory(){}

    public static AwtWindowFactory instance(){
        if (uniqueInstance == null){
            uniqueInstance = new AwtWindowFactory();
        }
        return uniqueInstance;
    }

    @Override
    protected WindowImp windowFactoryMethod(String title, Window w) {
        return new AwtWindow(title,w);
    }
}
