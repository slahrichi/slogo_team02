## SLogo API Changes
### TEAM 02
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie


## Changes to the Initial APIs

### Backend External

* Method changed:
  Deleted write method in pen class

    * Why was the change made?
      This was done because this write method is something that is being handled by the frontend. The back end tells the front end if the pen is up or down, and changes the posotion of the turtle based off the commands passed to it. the Front end actually draws the line on the screen.


* Major or Minor (how much they affected your team mate's code)
  This only meant that my teammates had to know what the position of the pen is(up or down)

* Better or Worse (and why)
  This change makes the front end do some computation with respect to thinking about where to draw the lines, which is worse, but makes the functionality of the tutle and pen a lot simpler (better) and error free.



* Method changed:
  Added method changeObjectLocation()

    * Why was the change made?
      This method was added so that the turtle's position could be changed inside of its own class

    * Major or Minor (how much they affected your team mate's code)
      Having this method being implemented inside the turtle method iteslf rather than in the turtlemanager class means that whenever a class would want to change the location of the turtle, it would need to call it on the turtle and not on the turtle manager class.

    * Better or Worse (and why)
      This chane is better because the "intelligence is spread" in the project and the turtle is not simply a setter / getter.


### Backend Internal

* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)


* Method changed:

    * Why was the change made?
      We first assumed that we would have a seperate class for FileReader that would read the text from the file and send that information to the Parser. We decided to do without it because converting a text to a string could be done in one line inside the Parser directly.

    * Major or Minor (how much they affected your team mate's code)
      This was a minor change as in any case, the other teammates only called the parser's getCommand. The inner design to reach that list is hidden to them.
    * Better or Worse (and why)
      While one could always argue that it is best to seperate features into different classes, this is only one line and one could also argue that file reading is part of the parsing.

### Frontend External

* Method changed: AnimationHandler and TurtleView Classes createAnimation

    * Why was the change made?

We initially were confused on where to create the animation and how we were going to pass in the correct turtle image to move. We decided on creating an animation class to specifically handle this rather than put the animation creating method in the TurtleView class.

* Major or Minor (how much they affected your team mate's code)

This decision majorly affected my teammate's (Mike's) code as we had to closely work together in order to integrate a way to connect the front and back end part of the view.

* Better or Worse (and why)

I would say that this decision was for the better as it better encompassed the single responsibility principle and open-closed. Now that the animation is in its own class, the Turtle and Animation objects are more abstract as well as easily extendible without breaking TurtleView in the process.


* Method changed: notifyHistory method in slogoGUI

    * Why was the change made?

Part of the ViewAPI, we created this method to notify the front end when to check the backend for an update to the command history


* Major or Minor (how much they affected your team mate's code)

This ViewAPI change had a minor affect on my teammate's code as he only had to call the public ViewAPI method to notify me of a change. This was kind of a pseudo observer.

* Better or Worse (and why)

In the end, it was better than many of the other options we had, including passing the controller all the way into the CommandHistory class itself to use for extracting information.


### Frontend Internal

* Method changed: Creation of an internal observer to handle internal changes (ex: dynamically changing color of graphical context background)

    * Why was the change made?

Internal observer design pattern made it easier to notify different classes in the View of a certain event occuring like a button being pressed in the informational panel

* Major or Minor (how much they affected your team mate's code)

Didn't really affect my teammate's code as this was an internal change

* Better or Worse (and why)

This creation of an observer definitely improved the single responsbility and open closed principle of my code, allowing me to notify multiple and different subscribers if necessary at my disposal.


* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)

