package slogo.Control;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.Pen;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * This class keeps record of all turtles and executes stepTurtle function on them
 *
 */
public class TurtleManager implements TurtleManagerAPI {
  // Can make into list if we have multiple turtles
 // List<Turtle> turtles;
  Turtle currentTurtle;

  public TurtleManager(){
    Pen pen = new Pen(Color.BLUE, true, 1);
    currentTurtle = new Turtle(0, 0, 270, pen);
  }

//  public void setCurrentTurtle(Turtle currentTurtle) {
//    this.currentTurtle = currentTurtle;
//  }

  //public Turtle getCurrentTurtle(){
  //  return currentTurtle;
  //}

  public TurtleRecord getRecordTurtle(){
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
        currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
        currentTurtle.getOldY(), currentTurtle.getOldAngle());
  }

 // public void setCommands(Collection<Command> newCommands){
 //   commands.addAll(newCommands);
//  }

  public void stepTurtle(CommandAPI command) throws ModelExceptions {
    command.execute(currentTurtle);
  }
}
