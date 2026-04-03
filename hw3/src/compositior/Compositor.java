package compositior;

import glyph.Composition;

/**
 *  Compositor follows the Strategy class of the Strategy Design Pattern
 */
public interface Compositor {
    void setComposition(Composition composition);
    void compose();
}
