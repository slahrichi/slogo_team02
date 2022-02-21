package slogo.Controller;

import java.util.ArrayList;
import java.util.List;
import slogo.Model.Turtle;

public class TurtleHelper {
  // Can make into list if we have multiple turtles
  List<Turtle> turtles;
  List<Command> commands;
  Turtle currentTurtle;
  public TurtleHelper(){
    Turtle turtleOne = new Turtle(0, 0, 0);
    turtles = new ArrayList<>();
    turtles.add(turtleOne);
    currentTurtle = turtleOne;
    commands = new ArrayList<>();
  }

  public void setCurrentTurtle(Turtle currentTurtle) {
    this.currentTurtle = currentTurtle;
  }

  public Turtle getCurrentTurtle(){
    return currentTurtle;
  }

  public getCommands(){
    commands.add(inputParser.getCommands());
  }

  public step(){
    currentTurtle.execute(commands[commandIndex]);
  }
}
