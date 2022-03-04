package slogo.Control;

import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;

public interface TurtleManagerAPI {
  TurtleRecord getTurtleRecord(int turtleID);
  void stepTurtle(CommandAPI command) throws ModelExceptions;
}
