## SLogo
### TEAM 02
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie

Timeline
Start Date: 02/10/2022
Finish Date: 03/05/2022
Hours Spent:

Haris ~ 35 hours
Mike ~ 35 hours
Saad ~ 40 hours
Eric - 40 hours

## Primary Roles


### Haris

Handled the backend - specifically implementing the turtle, Pen , Turtle Manager, Commands, and Variables, and tests for these parts.



### Mike

I worked on the Controller which entailed heavily communicating with the different parts of the project in order to decide how to integrate the program. I also took on a lot of the backend work such as implementing the different commands and the turtle manager. I spent a lot of my time talking with my teamates about how the controller should interact and how to make the commands in order to work well with the parser. I also worked on tests from all of the different parts of the program.


### Saad

Main focus was on the parsing of the user instructions to create Commands the Model can understand and execute on the turtle.
Added tests for the Parser.


### Eric

Handled the front-end, building the slogo GUI from the ground up using JavaFX. Heavily involved with integrating the view side of the MVC with the controller in order to set up the animation and logic. Created tests to cover most of the view side classes and lines.




### Resources Used
Reflection Lab, Design Patterns Readings, TestFX documentation

https://www.pngmart.com/image/276452

https://www.pinterest.com/pin/397231629636256629/?d=t&mt=login



## Running the Program
### Main class:
Main.java

### Data files needed:
files in slogo.languages contain all the resource files we need to load the program in any language, as well as our exception messages, and a file that maps commands to the number of parameters expected.

### Features implemented:
Basic SLogo program, change pen/background color, load file, save file, command history, shell that remembers old commands (move through them using up and down arrow keys)


### Controller

Initializes Translater object that reads string of the user instructions and translates them to commands. The Translater returns a list of ordered commands to execute, which gets passed to the Turtle. The Controller also intializes the TurtleManager which updates the turtles based on the passed commands.



### Visualization

The View side of the MVC holds the user interface, which contains the different tools to move the turtle. On the left side, there is an input panel with the shell and file editor where you can type commands. On the right, there are drop down panels with different kinds of tools such as ones that show the command history and ones that change the color.

At the bottom, there are configuration buttons that help you with moving the turtle. You can upload .slogo files from your file explorer and save files that you have made in the file editor to the data/saves folder. You can also create new slogoGUI interfaces and reset the canvas of your current slogoGUI interface.




### Model

The model is composed of turtle objects which are updated based on commands when the TurtleManger calls command.execute(Turtle). These commands update the turtle that is passed to it in its execute function. They are initialized by the parser and then passed to the controller which calls TurtleManager.stepTurtle() for each command passed to it.





## Notes/Assumptions
### Assumptions or Simplifications:


* Controller -
  We assume we are passed a String that we read from, or a file that can be converted to a string. If the file contains any token that is not part of the Syntax, the Parser throws an error.


* Visualization -

For the visualization, I made assumptions about what I was getting from the back-end, specifically that the information about the turtle and when they were calling my API methods were correct. For example, in the AnimationHandler class, we take advantage of a TurtleRecord object, which separates the back and front-end with a database of sorts. From here, I get the old X, Y and new X, Y of the turtle and update it in the front end as commands are made.




* Model -

We assumed that the turtle will be passed correct command from the parser with the correct data structure(list in our case). Further, we assumed that the turtle will only draw straight lines and will displace in lines as well.



## Known Bugs:

One known bug is that depending on the computer it is run on, the program can pull up on the screen not showing all its components. For example, on Mike's computer, the window would pull up but have the configuration buttons cut off at the bottom. If a person with a much smaller window opened this program, it would be likely that they would run into this trouble, which could be solved by dragging and dropping the window until everything shows.

Another bug has something to do with the record and animationhandler, in which, the turtle seems to incorrectly move. In fact, it does animations twice and in the incorrect order.

ResetCanvas button has its bugs and Changing the Background color can erase work done already.


## Impressions

Haris - The project started at a good, viable pace, as we were able to cope up with testing initially, but we realised that our model had many problems in it and we hastened to have a working peice as soon as we could, overlooking some design improvements. Unfortunately, I was not able to extend the back end too much after the basic implementation because we were caugt in debugging problems with our parser and frontend, although functionality for multiple turltes was created. However, this was my first project in which I worked on the beackend only and conciously tried to use the Design Concepts taught in class to improve my code as much as possible, adding and deleting code over and over again and testing different variations of what could work with better design. We had communication problems between our classes and if we were able to sort those problems out early in the project, we wouldn't have as much of a hard time making the program work in the end.

Mike - This project was definately a struggle. I thought that we were on the right track but then kept on running into issues whether if it was a design choice for how to pass in the correct instance of a class well or practical ones like the parser, view, or model not working properly. I feel like we tried our best and could have banged our head against our computers more to get stuff done but I think that we put in a good amount of work and thought through it. It was a great oppurtunity to use some new patterns and we relied on reflection heavily in order to initialize the command classes which were well abstracted.

Saad - This project was a lot more challenging than the previous one yet was a great chance to practice the design conventions we learned about in class. This was also a chance to write tests for our code and ensure we have a high enough coverage. One of the biggest issues we encountered was making sure we are all (Model, View, and Controller) talking to the same object at the same time (same turtle, same List of commands, same Stack, same Stage...). It also felt as if we could have added more design patterns in our code, especially in the Parser part so as to make it less STUPID and more SOLID. Although our final project does not implement some of the features that Basic requires, I feel like everyone did their best.


Eric - This was my first taste of working in front-end ever in coding, especially with JavaFX. In the previous project, I enjoyed working in the back-end and not worrying with much of the integration with the front-end. Because of this, I would say the slogo project was pretty challenging especially when I was working with Mike heavily to integrate the controller and view. We would go back and forth on potential ways for the animation, turtle image, and controller to communicate.

One of my favorite part of this project was actually getting introduced to the design patterns, albeit a bit late into the project. It definitely expanded my mindest in how I could approach these integration problems and good software design in general. For example, I tried implementing Singleton initially before being told it was STUPID code by Duvall. But later, I tried implementing a pseudo Observer that seemed to work in the end. Even though they weren't perfect, it was satisfying to feel that I was growing as programmer.

I'm disappointed that we didn't get to fully implement the Change portion of Slogo much less fully work out the functional part of Basic, but I think we gave it our best. There's without a doubt a lot of improvements that I would make if I had the time, and I will be greatly detailing them and potential solutions in the design analysis later.

Regardless, I actually enjoyed experiencing work with the front-end. There's just something satisfying about taking data and displaying them visually compared to just working with logic in the back-end, which you usually can't see. This decision to take on UI definitely has pushed me to continue to pursue being a full-stack software engineer in the future.