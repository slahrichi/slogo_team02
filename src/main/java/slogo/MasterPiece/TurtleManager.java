package slogo.MasterPiece;


import java.util.ArrayList;
import java.util.List;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;
import slogo.Model.Pen;
import slogo.Model.Turtle;
import slogo.Model.TurtleManagerAPI;
import slogo.Model.TurtleRecord;

/**
 * @author Mike Keohane, Haris Adnan.
 * This class keeps record of all turtles and executes stepTurtle function on them. Allows user to
 * add turtles and obtain information about turltes in the program.
 *
 * This class shows good design as it not only implements from an API, but also only provides the
 * user with a record and not the turtle itself. This goes in line with the Open-Closed Principle.
 * Further, there is implementation of lambda function, for example in th e function
 * addMultipleTurtles(). Exceptions are also thrown when the turlte requested cannot be found. The
 * stepTurtle() functiom is also implemented in such a way that reflection can be used with it.
 *
 * git commits: https://coursework.cs.duke.edu/compsci308_2022spring/slogo_team02/-/commit/5a57602214da648b8879ed5cae7fb7d26dbcd75d
 *
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
  // function returns the Turtle, given the ID, the function is purposelfully made public so that
  // it does not appear on the API.
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
   *
   * @return turtlelist.size()
   */
  public int numberOfTurtlesInList() {
    return turtleList.size();
  }

}
