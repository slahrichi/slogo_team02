package slogo.Model;

import javafx.scene.paint.Color;
import slogo.Control.TurtleRecord;
import slogo.Model.Commands.CommandAPI;

/**
 * @author Mike Keohane
 **/
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

  public TurtleRecord getRecordTurtle() {
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
