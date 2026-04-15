# Homework 4
### Ted Moore

## Compiling and running
The Lexi class can be run to recreate the test seen in the graphical demonstration in the  
Homework Outline. To compile and run:  
`javac */*.java Lexi.java`  
`java Lexi`

The default windowing system being used is Swing.
The user can change the this by using the LexiWindow environment variable by running:  
`LexiWindow=Awt java Lexi`

## Design Pattern Outline
The additions made to this assignment were mainly classes added for the AbstractFactory and
Bridge Design Patterns. The WindowFactory class mirrors the AbstractFactory class of AbstractFactory.
The two ConcreteFactory classes are Awt and SwingWindowFactory. Their products are Awt/SwingWindow.
These classes used the Bridge pattern and were the ConcreteImplementors, with WindowImp as the
Implementor class. The other part of the Bridge pattern was used by the Window and ApplicationWindow
classes. They mirrored the Abstraction and RefinedAbstraction classes respectively. 

Additional Patterns used were FactoryMethod, seen in WindowFactory and its subclasses
through abstracting method calls, and Singleton, seen in WindowFactory and its subclasses
with the static instance() methods.

