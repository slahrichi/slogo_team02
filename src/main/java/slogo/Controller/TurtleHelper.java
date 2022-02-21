package slogo.Controller;

import java.util.List;
import slogo.Model.Turtle;

public class TurtleHelper {
  // Can make into list if we have multiple turtles
  Turtle turtleOne;
  List<Command> commands;
  public TurtleHelper(){
    turtleOne = new Turtle(0, 0, commands, 0);
  }

  public Turtle getCurrentTurtle(){
    return turtleOne;
  }

}
