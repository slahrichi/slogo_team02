package slogo.Model;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import slogo.Model.Commands.CommandAPI;

/**
 * @author Mike Keohane
 *
 * This class keeps record of all turtles and executes stepTurtle function on them
 ***/


public class TurtleManager implements TurtleManagerAPI {

  Turtle activeTurtle;
  private List<Turtle> turtleList;

  /**
   * constructs  the turtle manager and initializes one turtle to the starting position
   */
  public TurtleManager() {
    turtleList = new ArrayList<>();
    addNewTurtle(0);
    activeTurtle = turtleList.get(0);

  }


  /**
   * Creates a new turtle and adds it to the list. Assumes all turtles spawn from (0, 0 ), with
   * angle of 270 (to align up in view) and with their own down pen.
   */
  public void addNewTurtle(int turtleId) {
    Pen turtlePen = new Pen(true, 1);
    Turtle newTurtle = new Turtle(0, 0, 270, turtlePen, turtleId);
    turtleList.add(newTurtle);
  }

  /**
   * Given a turtle id, sets the active turtle to that ID
   *
   * @param newTurtleId id for the active turtle
   * @throws TurtleManagerException
   */
  public void changeActiveTurtle(int newTurtleId) throws TurtleManagerException {
    activeTurtle = getTurtle(newTurtleId);
  }

  /**
   * Adds multiple new turtles with ids specified
   *
   * @param turtleIds list of integers of ids
   */
  public void addMultipleTurtles(List<Integer> turtleIds) {
    turtleIds.forEach(id -> addNewTurtle(id));
  }

  /**
   * Returns a record of the turtle specified by the id
   *
   * @param turtleId int ID of turtle
   * @return Turtle Record record object
   */
  public TurtleRecord getRecordTurtle(int turtleId) throws TurtleManagerException {
    Turtle currentTurtle = getTurtle(turtleId);
    return new TurtleRecord(currentTurtle.getTurtleX(), currentTurtle.getTurtleY(),
        currentTurtle.getAngle(), currentTurtle.isPenDown(), currentTurtle.getOldX(),
        currentTurtle.getOldY(), currentTurtle.getOldAngle(), currentTurtle.getTurtleID());
  }

  /**
   * Gets the id for the latest turtle added. Useful in a command we didn't implement
   *
   * @return int that corresponds to the id
   */
  public int getLatestTurtleAddedId() {
    return turtleList.get(turtleList.size() - 1).getTurtleID();

  }

  private Turtle getTurtle(int idOfTurtle) throws TurtleManagerException {

    for (Turtle turtle : turtleList) {
      if (turtle.getTurtleID() == idOfTurtle) {
        return turtle;
      }
    }
    throw new TurtleManagerException("Could not find requested turtle");
  }

  /**
   * Steps the turtle by calling execute on the inputted command
   *
   * @param command
   */
  public void stepTurtle(CommandAPI command) throws ModelExceptions {
    command.execute(activeTurtle);
  }

  /**
   * Returns the number of turtles
   * @return turtlelist.size()
   */
  public int numberOfTurtlesInList(){
    return turtleList.size();
  }

}
