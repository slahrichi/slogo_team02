package slogo.Control;

import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;

public interface TurtleManagerAPI {
  TurtleRecord getRecordTurtle(int turtleID);
  void stepTurtle(CommandAPI command, int turtleID) throws ModelExceptions;
}
