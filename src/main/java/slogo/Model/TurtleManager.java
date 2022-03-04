package slogo.Model;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import slogo.Model.Commands.CommandAPI;

/**
 * @author Mike Keohane

 * This class keeps record of all turtles and executes stepTurtle function on them
 ***/



public class TurtleManager implements TurtleManagerAPI {

  Turtle activeTurtle;
  private List<Turtle> turtleList;

  public TurtleManager(){
   turtleList = new ArrayList<>();
   addNewTurtle(0);
  }

  //function assumes all turtles spawn from (0, 0 ), with angle of 270 and with their own down pen.
  public void addNewTurtle(int turtleId){
    Pen turtlePen = new Pen(Color.BLUE, true, 1);
    Turtle newTurtle = new Turtle(0, 0, 270, turtlePen, turtleId);
    turtleList.add(newTurtle);
  }

  public void changeActiveTurtle(int newTurtleId) throws TurtleManagerException {
    activeTurtle = getTurtle(newTurtleId);
  }

  public void addMultipleTurtles(List<Integer> turtleIds){
    turtleIds.forEach(id -> addNewTurtle(id));
  }


  public TurtleRecord getRecordTurtle(int turtleId) {
    Turtle currentTurtle = turtleList.get(turtleId);
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
        currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
        currentTurtle.getOldY(), currentTurtle.getOldAngle(), currentTurtle.getTurtleID());
  }


  private Turtle getTurtle(int idOfTurtle) throws TurtleManagerException {

    for(Turtle turtle : turtleList){
      if(turtle.getTurtleID() == idOfTurtle){
        return turtle;
      }
    }
    throw new TurtleManagerException("Could not find requested turtle");
  }

  public int getLatestTurtleAddedId(){
    return turtleList.get(turtleList.size() - 1).getTurtleID();

  }

  public TurtleRecord getTurtleRecord(int id) throws TurtleManagerException {
    Turtle currentTurtle = getTurtle(id);
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
          currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
          currentTurtle.getOldY()
          , currentTurtle.getOldAngle(), currentTurtle.getTurtleID());
    }

  public void stepTurtle(CommandAPI command) throws ModelExceptions {
    command.execute(activeTurtle);
  }
}
