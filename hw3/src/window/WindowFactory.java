package window;

/**
 * WindowFactory uses Singleton, AbstractFactory, and FactoryMethod Design patterns.
 */
public abstract class WindowFactory {
    private static WindowFactory uniqueInstance;

    public static WindowFactory instance() {
        if (uniqueInstance == null) {
            String s = System.getenv("LexiWindow");
            System.out.println("LexiWindow env var = " + s); // debug
            if (s != null && s.equalsIgnoreCase("Awt")) {
                System.out.println("Using AWT");
                uniqueInstance = AwtWindowFactory.instance();
            } else {
                System.out.println("Using Swing");
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
