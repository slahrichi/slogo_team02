package slogo.Control;

import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;

public interface TurtleManagerAPI {
  TurtleRecord getRecordTurtle();
  void stepTurtle(CommandAPI command) throws ModelExceptions;
}
