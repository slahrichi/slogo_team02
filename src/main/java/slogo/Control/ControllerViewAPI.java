package slogo.Control;

import java.util.List;
import slogo.Model.ModelExceptions;
import slogo.View.Panels.CanvasPanel;

public interface ControllerAPI {

  void parseAndRunCommands(String contents) throws ModelExceptions, CommandException ;
  List<String> getHistory();
  TurtleRecord getRecordTurtle();
}
