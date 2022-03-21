# DESIGN Document for SLogo
## NAME(s) : Haris Adnan, Eric Xie, Mike Keohane, Saad Lahrichi


## Role(s)

* Team member #1: Haris Adnan - Handled the backend - specifically implementing the turtle, Pen , Turtle Manager, Commands, and Variables, exceptions and tests for these parts.

* Team member #2: Mike Keohane - Handled the controller which included communication in order to connect the aspects of the project together. Also worked on the backend by implementing commands and the turtle manager.

* Team member #3: Eric Xie - Handled the front-end, building the slogo GUI from the ground up using JavaFX. Heavily involved with integrating the view side of the MVC with the controller in order to set up the animation and logic. Created tests to cover most of the view side classes and lines.


* Team member #4: Saad Lahrichi - Worked on the parsing of user instructions to create Commands the Model can understand and execute on the turtle. Wrote tests and exceptions for parsing issues.



## Design Goals
* An IDE that allows users to write in commmands to command turtle(s) to move around. This turtle leaves behind a trail / line wherever it moves, allowing the user to draw different objects
* Allow user to:
- enter commands to the turtle interactively by entering text commands
- see errors that result from entered commands in a user friendly way (i.e., not just printed to the console)
- see history of successful commands previously run
- see user-defined variables
- see user-defined commands
- set an image to use for the turtle
- set a background color for the turtle's display area
- set a color to use for the pen
- set the speed to animate the turtles' movement and turning
- save and load a file of containing the current user-defined commands and variables
- select from different languages used for the text displayed
- select from different component styles

* Well tested program with atleast 70 percent class coverage.

## High-Level Design
* Controller
  Initializes Translater object that reads string of the user instructions and translates them to commands. The   Translater returns a list of ordered commands to execute, which gets passed to the Turtle. The Controller also intializes the TurtleManager which updates the turtles based on the passed commands.
  The parser was handling reading the user's input (text or uploaded file) from the View and calling the appropriate constructors from the Model. Then, storing these constructed command objects in a list of ordered commands that the Turtle executes.

* Visualization
  The View side of the MVC holds the user interface, which contains the different tools to move the turtle. On the left side, there is an input panel with the shell and file editor where you can type commands. On the right, there are drop down panels with different kinds of tools such as ones that show the command history and ones that change the color.
  At the bottom, there are configuration buttons that help you with moving the turtle. You can upload .slogo files from your file explorer and save files that you have made in the file editor to the data/saves folder. You can also create new slogoGUI interfaces and reset the canvas of your current slogoGUI interface.

* Model
  The model is composed of turtle and pen objects which are updated based on commands when the TurtleManger calls command.execute(Turtle). These commands update the turtle by the specific turtle record that is passed to it in its execute function. They are initialized by the parser and then passed to the controller which calls TurtleManager.stepTurtle() for each command passed to it.



## Assumptions or Simplifications
* Model: We assumed that the turtle will be passed correct command from the parser with the correct data structure(list in our case). Further, we assumed that the turtle will only draw straight lines and will displace in lines as well. Further, the turtle implementation assumes that the parser will pass it the id of the active turtle that will be moved.
* The parser expects to receive text data either directly from the View, or be passed a text file it would read from. It also expects the commands to be passed to be among the ones listed in the resource files and with the correct number of parameters being passed to each. Should there be a problem a custom exception gets thrown
* View: For the visualization, I made assumptions about what I was getting from the back-end, specifically that the information about the turtle and when they were calling my API methods were correct. For example, in the AnimationHandler class, we take advantage of a TurtleRecord object, which separates the back and front-end with a database of sorts. From here, I get the old X, Y and new X, Y of the turtle and update it in the front end as commands are made.


## Changes from the Plan
We were originally supposed to finish most of basic commands and do some of the advanced changes. We spent a lot of time trying to figure out the proper way to work on our respective parts, connect them effectively, and ensure the turtle/pen/canvas the Model, View, and Controller are talking to are the same instance. We also spent a lot of time planning on the best way to handle multiple turtles. Although our final product does not support that, the structure we have makes it easy by using an index of each turtle.

## How to Add New Features
* To add a new language command, it would require adding the command's name and the possible calls to it to each file according to language under src/main/resources/Commands/slogo.languages.properties We would also need to add to src/main/resources/Commands/Params.properties the name of our new command and the number of parameters it expects.
  Finally, we need to add to src/main/resources/slogo/languages/Types.properties the command name  as well as the type it belongs to (TurtleCommands, MathCommands, ...). This is due to the way  we use reflection to create command objects. Although Translater.java cannot deal with many cases yet.
  The structure is there for it to handle any possible command. The method parseText has one big switch that handles the nature of the token being parsed (Command, Constant, Bracket, ...) by calling the method that deals with each accordingly (handleUserCommand, handleConstant, ...)

* In order to implement loops and conditionals, it would require specific commands to be tagged as those types and then the parser can create a specific object that both contains a list of commands that need to be looped and the specific parameters. We started to implement the back end of that by creating an object (repeat) that takes in a list of commands as well as a double to specifiy how long it should repeat. In order to classify these loop/conditional seperately, the parser would have to create new pattern that correlates to the keys for these abstracted LoopAndConditionalCommands. It then would run a method that creates commands for each of the commands until the end of the parentheses and then constructs the loop command with that list of commands.

* the user can add as many new turtles as they want with commands. With the current implementation, they also have the ability to change the pen color or postion of a specific turtle, for example. To allow the user to click the turlte to change the active turtle, the front end will need to provide the backend with information about where the user clicked, using this, we'll be ableto know which turtle the user clicked and the active turtle can be changed then using the changeActiveTurtle() method in TurtleManager class.

