# Collections API Lab Discussion
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie
### Team 2


## In your experience using these collections, are they hard or easy to use?

These collections are generally easy to use. If not, I would search up their functionality on Oracle. The Java API is fleshed out, making it easy for users to implement their code.

## In your experience using these collections, do you feel mistakes are easy to avoid?

Because of how these collections are created, mistakes are usually easy to avoid. It is the user's responsibility to make sure to use the correct method calls (e.g: Collection.size() vs Collection.length())

## What methods are common to all collections (except Maps)?
One method that is common is the .add method, which allows you to add elements into a collection. Another one is .clear(), allowing users to wipe the entire collection they're using in one go. There are many more examples, including the .isEmpty() and .size() methods.


## What methods are common to all Deques?
addFirst()

addLast()

contains()

removeFirst()

peekFirst()

addLast()

removeLast()

getFirst()

add()

## What is the purpose of each interface implemented by LinkedList?
Serializable - Enables it to be seriablized or deserialized basically letting the LinkedList be stored or transmitted and reconstructed later.
Cloneable - Enables the LinkedList to be able to make field-for-field copies of an instance.
Iterable - Lets the LinkedList be the target of a for-each loop.
Collection - The root interface that represents a group of objects known as it's elements.
Deque - Linear element that supports insertion and removal on both ends of the LinkedList.
List - Ordered collection/sequence of objects that gives the user precise control on where they can insert elements
Queue - Allows for the holding of elements before they're processed

## How many different implementations are there for a Set?

There are three general-purpose Set implementations — HashSet , TreeSet , and LinkedHashSe

## What is the purpose of each superclass of PriorityQueue?

A priority Queue is an extension of the queue. They have the following properties:


* Every item has a priority associated with it.

* An element with high priority is dequeued before an element with low priority.

* If two elements have the same priority, they are served according to their order in the queue.

Its superclasses are:

* Abstract Queue

* Abstract Collection


## What is the purpose of the collection utility classes?

The Collection Utility classes holds the framework of collections as well as many miscellaneous classes that have functions ranging from generating random numbers to parsing through strings. It also contains some time and legacy content.

The collection utility classes extend the object class and includes all the methods that affect collections and return them.


## API Characterics applied to Collections API

* Easy to learn

Documentation and descriptive variable names provided make learning or grasping what the methods do far more streamlined. Furthermore, because the Collections superclass has overaching methods that can be applied to each one, making methods like .add and .isEmpty transferrable.


* Provides for extension

Most Collection types Have a Superclass that have different implementations, Such as: Set -> HashSet.

* Leads to readable code

The consistent class and method names made the code easier to read.

* Hard to misuse

  Because no single collection type will contain methods that will have similar / same names but have different implentations. For every collection type, one can easily find documentation on what methods it has and how they are used.
    