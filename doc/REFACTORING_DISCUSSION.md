## Refactoring Lab Discussion
### TEAM 02
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie



## Issues in Current Code

### Method or Class

* Design issues - Singleton Controller View Instance

From class, we learned that the Singleton design pattern falls under STUPID (S) and not SOLID code. This design pattern unfortunately has many poor tradeoffs for a few benefits.

For example, the pattern violates the Single Responsibility principle, solving 2 problems at a time. Furthermore, it's used to mask poor code smells.

In the front end, we use this singleton controller instance to be able to pass one instance of the controller among multiple view classes, which is my justification. However, I understand the tradeoffs of this, and a solution may be just to pass the controller through the constructors of the classes that use it, which isn't very friendly either.



* Design issue
  Pen was being passsed in X and Y value, which it doesn't need.

### Method or Class
* Design issues

Turtle Manager does not have the ability to store multiple turtle instances, and can only store one turlte for now. This means that there is a singleton Controller class that calls a single turtle manager.


* Design issue



## Refactoring Plan

* What are the code's biggest issues?

The code's biggest issues I would say are the crossed dependencies and classes with multiple responsibilities. Finding a solid way for the view model and controller to communicate with each other has been tough, and our code currently reflects that.

Handling exceptions and creating more tests are also another issue we need to take care of.

* Which issues are easy to fix and which are hard?

Based off the static analysis online, some issues that would be decently easy to fix would be preserving the original exceptions when caught.

* What are good ways to implement the changes "in place"?

Making exceptions and catchimg them


## Refactoring Work

* Issue chosen: Fix and Alternatives

Removing X and Y values for the pen. Alternative: keep it there fro extraneous information and completely seprate it from the Turtle.


* Issue chosen: Fix and Alternatives

To fix the single turtle issue, we need to have Turtle manager store multiple turtle and have an ID associated with each turtle so that the turtles can be uniquely called.