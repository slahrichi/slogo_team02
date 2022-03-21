package slogo.Control;

import java.util.List;
import slogo.Model.TurtleManagerException;
import slogo.Model.TurtleRecord;
/**
 * @author Mike Keohane
 *
 * The controller parses and runs an input of strings on the turtles
 * It also contains and updates the history
 */
public interface ControllerAPI {

  void parseAndRunCommands(String contents) throws Exception;
  TurtleRecord getRecordTurtle() throws TurtleManagerException;
  List<String> getHistory();
  void resetHistory();
}
