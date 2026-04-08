package window;


public abstract class WindowFactory {
    private static WindowFactory uniqueInstance;

    public static WindowFactory instance() {
        if (uniqueInstance == null) {
            String s = System.getenv("LexiWindow");
            if (s != null && s.equalsIgnoreCase("Awt")) {
                uniqueInstance = new AwtWindowFactory();
            } else {
                uniqueInstance = new SwingWindowFactory();
            }
        }
        return uniqueInstance;
    }

    public final WindowImp createWindow(String title, Window w) {
        return windowFactoryMethod(title,w);
    }

    protected abstract WindowImp windowFactoryMethod(String title, Window w);
    }
