package slogo.Controller;

import java.util.ArrayList;
import java.util.List;
import slogo.Model.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class TurtleManager {
  // Can make into list if we have multiple turtles
 // List<Turtle> turtles;
  List<Command> commands;
  Turtle currentTurtle;
  int commandIndex;
  InputParser inputParser;
  public TurtleManager(InputParser inputParser){
    Turtle turtleOne = new Turtle(0, 0, 0);
    currentTurtle = turtleOne;
    commands = new ArrayList<>();
    this.inputParser = inputParser;
  }

//  public void setCurrentTurtle(Turtle currentTurtle) {
//    this.currentTurtle = currentTurtle;
//  }

  public Turtle getCurrentTurtle(){
    return currentTurtle;
  }

  public void setCommands(){
    commands.addAll(inputParser.getCommands());
  }

  public void step() throws ModelExceptions {
    if (commandIndex < commands.size()){
      commands.get(commandIndex).execute();
      commandIndex++;
    }
  }
}
