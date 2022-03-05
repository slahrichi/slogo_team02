## SLogo
### TEAM 02
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie

Timeline
Start Date: 02/10/2022
Finish Date: 03/05/2022
Hours Spent:

Haris- hours.
Mike - hours
Saad ~ 25 hours
Eric - 25 hours

## Primary Roles


### Haris-





### Mike

I worked on the Controller which entailed heavily communicating with the different parts of the project in order to decide how to integrate the program. I also took on a lot of the backend work such as implementing the different commands and the turtle manager. I spent a lot of my time talking with my teamates about how the controller should interact and how to make the commands in order to work well with the parser. I also worked on tests from all of the different parts of the program.


### Saad-

Main focus was on the parsing of the user instructions to create Commands the Model can understand and execute on the turtle.
Added tests for the Parser.


### Eric

Handled the front-end, building the slogo GUI from the ground up using JavaFX. Heavily involved with integrating the view side of the MVC with the controller in order to set up the animation and logic. Created tests to cover most of the view side classes and lines.




### Resources Used
Reflection Lab, Design Patterns Readings, TestFX documentation



## Running the Program
### Main class:
Main.java

### Data files needed:
files in slogo.languages contain all the resource files we need to load the program in any language, as well as our exception messages, and a file that maps commands to the number of parameters expected.

### Features implemented:
Basic SLogo program, change pen/background color, load file,


### Controller

Initializes Translater object that reads string of the user instructions and translates them to commands. The Translater returns a list of ordered commands to execute, which gets passed to the Turtle. The Controller also intializes the TurtleManager which updates the turtles based on the passed commands.



### Visualization




### Model






## Notes/Assumptions
### Assumptions or Simplifications:


* Controller -
  We assume we are passed a String that we read from, or a file that can be converted to a string. If the file contains any token that is not part of the Syntax, the Parser throws an error.


* Visualization -




* Model -





## Known Bugs:

One known bug is that depending on the computer it is run on, the program can pull up on the screen not showing all its components. For example, on Mike's computer, the window would pull up but have the configuration buttons cut off at the bottom. If a person with a much smaller window opened this program, it would be likely that they would run into this trouble, which could be solve



## Noteworthy Features:




## Impressions

Haris -

Mike - This project was definately a struggle. I thought that we were on the right track but then kept on running into issues whether if it was a design choice for how to pass in the correct instance of a class well or practical ones like the parser, view, or model not working properly. I feel like we tried our best and could have banged our head against our computers more to get stuff done but I think that we put in a good amount of work and thought through it. It was a great oppurtunity to use some new patterns and we relied on reflection heavily in order to initialize the command classes which were wel

Saad - This project was a lot more challenging than the previous one yet was a great chance to practice the design conventions we learned about in class. This was also a chance to write tests for our code and ensure we have a high enough coverage. One of the biggest issues we encountered was making sure we are all (Model, View, and Controller) talking to the same object at the same time (same turtle, same List of commands, same Stack, same Stage...). It also felt as if we could have added more design patterns in our code, especially in the Parser part so as to make it less STUPID and more SOLID. Although our final project does not implement some of the features that Basic requires, I feel like everyone did their best.


Eric - 