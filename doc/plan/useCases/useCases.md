# SLogo Use Cases

### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie

### Team 02

#### Given Use Cases

* The user types 'fd 50' in the command window, and sees the turtle move in the display window
  leaving a trail, and the command is added to the environment's history.

~~~
TurtleInterface:

// assuming playerInput variable is String containing the command they wrote
commandSubmitted(playerInput);

// Then goes to the Controller TurtleManager:
setTurtleCommands(playerInput);

Goes to the back-end and modifies the Turtle's position, then call the displayTurtle() and 
updateScriptWindow() methods to update the simulation window

Now, the script window shows the newly entered the command and the moved turtle
~~~

* The user types '50 fd' in the command window and sees an error message that the command was not
  formatted correctly.
* The user sets a variable's value and sees it updated in the UI's Variable view.

~~~
First the UI reads handles the in a text box

Next the GUI helper takes the input and with an updateVariable() changes the variable 
corresponding to what was specified by the user.

The GUI then is then updated because the GUI helper instace will be updated and the values shown 
in the GUI are stored there.
~~~

* The user sets the pen's color using the UI so subsequent lines drawn when the turtle moves use
  that color.

#### Added Use Cases - 3 per Person

* Inputting an Invalid File Type

~~~

~~~

* Inputting a Wrongly Formatted Slogo File

~~~

~~~

* Set Simulation Speed

~~~

~~~
* Read Inputs from a file
~~~
FileReader parses the text file and throws and exceptions (bad file etc.)

FileReader then passes the text per command to the InputParser and it creates the commands
just like it would for UI string inputs

The backend turtle is then updated accordingly in the turleManager then animated once the
 user clicks play, by stepping it and the pen in those view classes.
~~~
* The user wants to change the language
~~~
In a dropdown box in the GUI, the user selects the language they want. (GUI helper give GUI list
 of .properties files) 

Once they click "apply", the GUI helper in a setLanguage() changes the path of the resources to the
corresponding .properties file using a switch case.
~~~
* The turle hits the edge of the screen
~~~
The turtle class has a ifHitBounds() so where the turtle will stop moving (or wrap or bounce) when
if called.

Only the view will know the exact positioning of the turtle and therefore the turtleView will have
call the ifHitBounds() from turtle instance in TurtleHelper therefore making the turtle perform 
whatever action we decide. 
~~~