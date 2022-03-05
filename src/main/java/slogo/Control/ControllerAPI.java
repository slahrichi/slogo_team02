package slogo.Control;

import java.util.List;
import slogo.Model.TurtleManagerException;
import slogo.Model.TurtleRecord;

public interface ControllerAPI {

  void parseAndRunCommands(String contents) throws Exception;
  TurtleRecord getRecordTurtle() throws TurtleManagerException;
  List<String> getHistory();
  void resetHistory();
}
