package window;

/**
 * WindowFactory uses Singleton, AbstractFactory, and FactoryMethod Design patterns.
 */
public abstract class WindowFactory {
    private static WindowFactory uniqueInstance;

    public static WindowFactory instance() {
        if (uniqueInstance == null) {
            String s = System.getenv("LexiWindow");
            if (s != null && s.equalsIgnoreCase("Awt")) {
                uniqueInstance = AwtWindowFactory.instance();
            } else {
                uniqueInstance = SwingWindowFactory.instance();
            }
        }
        return uniqueInstance;
    }

    public final WindowImp createWindow(String title, Window w) {
        return windowFactoryMethod(title,w);
    }

    protected abstract WindowImp windowFactoryMethod(String title, Window w);
    }
