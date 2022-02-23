package slogo.Control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import slogo.Model.commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class TurtleManager {
  // Can make into list if we have multiple turtles
 // List<Turtle> turtles;
  List<Command> commands;
  Turtle currentTurtle;
  int commandIndex;

  public TurtleManager(){
    currentTurtle = new Turtle(0, 0, 0);
    commands = new ArrayList<>();
  }

//  public void setCurrentTurtle(Turtle currentTurtle) {
//    this.currentTurtle = currentTurtle;
//  }

  public Turtle getCurrentTurtle(){
    return currentTurtle;
  }

  public void setCommands(Collection<Command> newCommands){
    commands.addAll(newCommands);
  }

  public void step() throws ModelExceptions {
    if (commandIndex < commands.size()){
      commands.get(commandIndex).execute(currentTurtle);
      commandIndex++;
    }
  }
}
