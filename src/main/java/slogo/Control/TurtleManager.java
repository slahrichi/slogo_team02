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
  private List<Turtle> myTurtleList;
//  int indexInTurtleList =0;

  //DECIDE ON WHAT TO DO FOR INITIAL CONDITION WHEN myTurtleList IS EMPTY.
  Turtle myActiveTurtle;

  public TurtleManager(List<Turtle> turtleList){
    this.myTurtleList = turtleList;
    if(turtleList.isEmpty()){
      addTurtle(0);
      this.myActiveTurtle = getLatestTurtleAdded();
    }
    else{
      this.myActiveTurtle = getLatestTurtleAdded();
    }
  }
  //function assumes all turtles spawn from (0, 0 ), with angle of 270 and with their own down pen.
  public void addTurtle(int newTurtleID){
    Pen turtlePen = new Pen(Color.BLUE, true, 1);
    Turtle newTurtle = new Turtle(0, 0, 270, turtlePen, newTurtleID);
    myTurtleList.add(newTurtle);
//    indexInTurtleList +=1;
  }
  public void changeActiveTurtle(int newTurtleId){
    try {
      this.myActiveTurtle = getTurtle(newTurtleId);
    } catch (TurtleManagerException e) {
      e.printStackTrace();
    }
  }

  public void addMultipleTurtles(List<Integer> turtleIds){
    for (int id : turtleIds){
      addTurtle(id);
    }
  }

  public Turtle getActiveTurtle() throws TurtleManagerException {
    for(Turtle loopTurtle : myTurtleList){
      if(loopTurtle.getTurtleID()== myActiveTurtle.getTurtleID()){
        return loopTurtle;
      }
    }
    throw new TurtleManagerException("Could not find active turtle");
  }

  public Turtle getTurtle(int idOfTurtle) throws TurtleManagerException {
    //use lambda expression here
    for (Turtle loopTurtle : myTurtleList) {
      if (loopTurtle.getTurtleID() == idOfTurtle) {
        return loopTurtle;
      }
    }
    throw new TurtleManagerException("Could not find requested turtle");
  }

  public Turtle getLatestTurtleAdded(){
    return myTurtleList.get(myTurtleList.size() - 1);

  }

  public TurtleRecord getTurtleRecord(int id) {
    Turtle currentTurtle = null;
    try {
      currentTurtle = getTurtle(id);
    } catch (TurtleManagerException e) {
      e.printStackTrace();
    }
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
          currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
          currentTurtle.getOldY()
          , currentTurtle.getOldAngle());
    }

  public void stepTurtle(CommandAPI command) throws ModelExceptions {
    command.execute(this.myActiveTurtle);
  }
}
