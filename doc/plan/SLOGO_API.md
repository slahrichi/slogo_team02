# SLogo API Design Lab Discussion
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie
### TEAM 02


## Planning Questions

* What behaviors (methods) should the Turtle have and what service should it provide?
    - move forward, backward, change its orientation, set stroke on/off, change its speed,
    - enter commands to the turtle interactively by entering text commands
    - see the results of the turtle executing commands displayed visually

    - see errors that result from entered commands in a user friendly way (i.e., not just printed to the console)
    - see history of successful commands previously run
    - see user-defined variables
    - see user-defined commands
    - set an image to use for the turtle (instead of the CSS style's default)
    - set a background color for the turtle's display area (instead of the CSS style's default)
    - set a color to use for the pen (instead of the CSS style's default)
    - set the speed to animate the turtles' movement and turning (where the max speed does no animation, just displaying the final result)

* When does parsing need to take place and what does it need to start properly?
    - parsing needs to be done after we check for the file sanity, and after setting up the stage and the turtle.

* What is the result of parsing (not the details of the algorithm) and who receives it?
    - the result of the parsing could be a list of actions the turtle can take and excecute sequentially.

* When are errors detected and how are they reported?
    - we should throw exceptions that check the parsed file and if it only contains acceptable commands, we should catch these errors and make sure the program still runs.
* What do different commands need to know, when do they know it, and how do they get it?
    - the data should be gotten from the parsed file, the commands need to know the required parameters (e.g: move should know whether forward or backward as well as move by how much)
* What behaviors does the result of a command need to have to be used by the View?

* How is the View updated after a command has completed execution?

* What value would Controller(s) have in mediating between the Model and View?


## APIs

### Model/Backend External API

* Goals

* Contract

* Services


### View/Frontend External API

* Goals

* Contract

* Services



### Model/Backend Internal API

* Goals

* Contract

* Services


### View/Frontend Internal API

* Goals

* Contract

* Services



## Design

### Backend Design CRCs

This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](order_crc_card.png "Order Class")

This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |

This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```

This class's purpose or value is to manage something:
```java
public class Something {
     // sums the numbers in the given data
     public int getTotal (Collection<Integer> data)
	 // creates an order from the given data
     public Order makeOrder (String structuredData)
 }
```


### Frontend Design CRCs


This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](order_crc_card.png "Order Class")

This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |

This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```

This class's purpose or value is to manage something:
```java
public class Something {
     // sums the numbers in the given data
     public int getTotal (Collection<Integer> data)
	 // creates an order from the given data
     public Order makeOrder (String structuredData)
 }
```



### Use Cases

* The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.

* The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.

* The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).

* The user changes the color of the environment's background.
