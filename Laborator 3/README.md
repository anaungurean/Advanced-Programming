# Laborator 3

- **Compulsory (1p)**
  - Create an object-oriented model of the problem. You should have at least the following classes: Person, Company.
  - Implement the interface `java.util.Comparable` for both classes. The natural order of the objects will be given by their names.
  - Create the interface `Node` that defines the method used to obtain the name of a person or company. The classes above must implement this interface.
  - Create a `java.util.List` containing node objects and print it on the screen.

- **Homework (2p)**
  - Create the complete model: Person, Programmer, Designer, Company. All persons have a birth date. Each class must have at least one specific property that others don't have (be creative).
  - Each person will contain a Map defining the relationships to other persons or companies.
  - Create the `Network` class containing a List of identifiable nodes.
  - Create a method that computes the importance of a node in the network, as the number of its connections to other nodes.
  - Create a network object containing persons, companies, and relationships, and print it on the screen. When printing the network, the nodes must be ordered according to their importance.

 
