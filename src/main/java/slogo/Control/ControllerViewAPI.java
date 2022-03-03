package slogo.Control;

import java.util.List;
import slogo.Model.ModelExceptions;

public interface ControllerViewAPI {

  void parseAndRunCommands(String contents) throws Exception;
  TurtleRecord getRecordTurtle();
  List<String> getHistory();
  void resetHistory();
}
