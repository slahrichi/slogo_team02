package slogo.Model;

import java.util.List;
import slogo.Model.Commands.CommandAPI;

/**
 * @author mike keohane API for the turtle manager with all of its public methods to be used by the
 * controller who creates and uses the manager
 */
public interface TurtleManagerAPI {

  TurtleRecord getRecordTurtle(int turtleID) throws TurtleManagerException;

  void stepTurtle(CommandAPI command) throws ModelExceptions;

  void addNewTurtle(int turtleID);

  void changeActiveTurtle(int turtleId) throws TurtleManagerException;

  int getLatestTurtleAddedId();

  void addMultipleTurtles(List<Integer> turtleIds);
  int numberOfTurtlesInList();
}
