package slogo.Control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.paint.Color;
import slogo.Model.Pen;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class TurtleManager {
  // Can make into list if we have multiple turtles
 // List<Turtle> turtles;
  List<Command> commands;
  Turtle currentTurtle;
  int commandIndex;

  public TurtleManager(){
    Pen pen = new Pen(Color.BLUE, true, 1, 100.0, 100.0);
    currentTurtle = new Turtle(0, 0, 0, pen);
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
