# Homework 3
### Ted Moore

## Compiling and running
The Lexi class can be run to recreate the test seen in the graphical demonstration in the  
Homework Outline. To compile and run:  
    `javac */*.java Lexi.java`  
    `java Lexi`

The Default look and feel value for the color of the buttons and labels will be red.
The user can change the value using the LexiWidget environment variable:  
    `LexiWidget=Green java Lexi`

## Design Pattern Outline
The additions made to this assignment were mainly classes added for the AbstractFactory
DesignPattern. The WidgetFactory class mirrors the AbstractFactory class of AbstractFactory.
The two ConcreteFactory classes are Red and GreenWidgetFactory. Button and Label classes, 
in the glyph package, are the AbstractProducts. Then, RedButton/GreenButton/RedLabel/GreenLabel
are all the ConcreteProducts. Additional Patterns used were FactoryMethod, seen in WidgetFactory
through abstracting method calls, and Singleton, seen in WidgetFactory in the instance() 
method calling the protected constructors. 

