# Homework 2
### Ted Moore

## Compiling and running
The Lexi class can be run to recreate the test seen in the graphical demonstration in the  
Homework Outline. To compile and run:  
    `javac */*.java Lexi.java`  
    `java Lexi`

## Design Pattern Outline
The additions made to this assignment integrated the Decorator design pattern into our  
existing classes that used the Composite and Strategy patterns. Embellishment is the  
Decorator class, and its ConcreteDecorators are Border and ScrollBar. It is an extension  
of the Composition class as it has children and must be able to be composed. 

