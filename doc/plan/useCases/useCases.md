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
~~~
// assuming the user passes a String
// this function calls the function createCommandFromText, which will throw an exception in this case
//and displays a message saying the input is invalid
public void inputFromUser(String command){
  List<Command> commands = InputParser.createCommandFromText(input)
} 
~~~
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
~~~
The user chooses a color from the dropdown list "PenColor".
The Controller's listener is notified of this change and calls the Model's
setColor(newColor) method 
~~~

#### Added Use Cases - 3 per Person

* Inputting an Invalid File Type

~~~
User inputs an invalid file type (something that is not .slogo)

FileReader parses the file and recognizes that it isn't the correct file type and 
throws an exception

We catch this exception using the InvalidFileException class, and we make sure to return
an error message to the user explaining the problem.

Program then returns to idle and waits for user to retry an upload
~~~

* Inputting a Wrongly Formatted Slogo File

~~~
User attempts to upload the correct slogo file, but it is incorrectly formatted (e.g.
missing a curly bracket).

When FileReader parses through the text, it catches the error and this time passes it to
the InvalidFormatFileException.java class, which returns an error message to the user

The user then has to edit the file or decide to upload a new file using the upload button
~~~

* Set Simulation Speed

~~~
User successfully uploads a file or writes commands and wants to play the commands. Before doing so,
they drag the speed slider to a certain position on the line and then click the play button.

Based on the position using a javaFx element, we pass its variable to the setUpAnimation() in 
TurtleView that creates the animation and the speed it steps through.
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
* Retrieve last executed call
~~~
The user types commands in the terminal and hits enter after each command 
to see it running. If the user wants to retrieve the last command they submitted
they can hit the UPARROW key.
~~~

* Pen thickness
~~~
The user can select the thickness of the lines drawn by the pen
by selecting a thickness value from the dropdown/inputting it in a GUI box
~~~

* Hide turtle
~~~
The user can choose to hide the Turtle from the Canvas to only
see the figure drawn (if any). They can do so by clicking on the 
Hide/View turtle toggle
~~~

* The User Places a new object on the Canvas
~~~ 
The User will be able to place a new object onto the canvas by inputting the type 
of object from the UI, selecting its color, and then setting its X and Y position on the 
Canvas
~~~

* Update the position of the objects in the view after a step
~~~

 //The view is updated for all the objects, including the turtles in the next step.
 
  public void updateObjects(TurtlArray arr) {
    View.updateTurtleView(arr);
  }
~~~

* The User changes the language
~~~
//Language value is obtained from an enum
public void changeLanguage(Language language){
  //Controller handles the update of language by displaying different text in the view class and using
  //the resources files for language
  Controller.setLanguage(language);
}
~~~