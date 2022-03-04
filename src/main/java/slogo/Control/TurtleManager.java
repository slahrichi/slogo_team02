package slogo.Control;

import java.util.ArrayList;
import java.util.Collections;
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
  List<Turtle> turtleList;
  int indexInTurtleList =0;

  public TurtleManager(List<Turtle> turtleList){
      this.turtleList = turtleList;

  }
  //function assumes all turtles spawn from (0, 0 ), with angle of 270 and with their own down pen.
  public void addTurtle(){
    Pen turtlePen = new Pen(Color.BLUE, true, 1);
    Turtle newTurtle = new Turtle(0, 0, 270, turtlePen, indexInTurtleList);
    turtleList.add(newTurtle);
    indexInTurtleList +=1;
  }

  public void addMultipleTurtles(int numberOfTurtlesToAdd){

    Collections.nCopies(numberOfTurtlesToAdd, 1)
        .stream()
        .forEach(i -> addTurtle());
  }


  public Turtle getTurtle(int idOfTurtle){
    Turtle returnTurtle = turtleList.get(idOfTurtle);
    return returnTurtle;
  }
  

  public TurtleRecord getTurtleRecord(int turtleID){
      Turtle currentTurtle = turtleList.get(turtleID);
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
        currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
        currentTurtle.getOldY(), currentTurtle.getOldAngle());
  }

  public void stepTurtle(CommandAPI command, int turtleId) throws ModelExceptions {
    Turtle turtleToExecute = turtleList.get(turtleId);
    command.execute(turtleToExecute);
  }
}
