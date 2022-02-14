# SLogo Use Cases

### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie

### Team 02

#### Given Use Cases

* The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.

~~~
TurtleInterface:

// assuming playerInput variable is String containing the command they wrote
commandSubmitted(playerInput);

// Then goes to the Controller TurtleManager:
setTurtleCommands(playerInput);
~~~

* The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
* The user sets a variable's value and sees it updated in the UI's Variable view.
* The user sets the pen's color using the UI so subsequent lines drawn when the turtle moves use that color.


#### Added Use Cases - 3 per Person