# Homework 5
### Ted Moore

## Compiling and running
The Lexi class can be run to recreate the test seen in the graphical demonstration in the  
Homework Outline. To compile and run:  
`javac */*.java Lexi.java`  
`java Lexi`

The default windowing system being used is Swing.
The user can change this by using the LexiWindow environment variable by running:  
`LexiWindow=Awt java Lexi`

The Default look and feel value for the color of the buttons and labels will be red.
The user can change the value using the LexiWidget environment variable:  
`LexiWidget=Green java Lexi`

## Design Pattern Outline
The additions made to this assignment were mainly classes added for the Command,
ChainOfResponsibility, and Prototype Design Patterns. The Command interface mirrors
the Command class of the Command pattern, with FontCommand serving as an abstract
ConcreteCommand and IncrementFontSizeCommand, DecrementFontSizeCommand,
SetFontSizeCommand, UndoCommand, and RedoCommand as the ConcreteCommands. The Receiver
role is played by the Window class for the font commands, since they call getFontSize(),
setFontSize(), and repaint() on it; UndoCommand and RedoCommand use CommandHistory as
their receiver. The Invoker role is shared by two classes: Button (in the glyph package),
which invokes its stored command on click, and ApplicationWindow, which invokes commands
looked up from the KeyMap on keystrokes. The Client role is played by the main program,
which constructs the ConcreteCommands and binds them to buttons and the KeyMap.

The ChainOfResponsibility pattern is seen through Glyph mirroring the Handler class 
with its default handleClick() returning false. CompositeGlyph mirrors a ConcreteHandler to 
propagate calls. Button mirrors a ConcreteHandler that claims the click and stops propagation.

The Command interface also mirrors the Prototype class through its copy() method, with
the same ConcreteCommand classes serving as ConcretePrototypes. Button and
ApplicationWindow act as the Prototype clients.

Additional patterns used were Singleton, seen in CommandHistory with its static instance()
method and private constructor.

