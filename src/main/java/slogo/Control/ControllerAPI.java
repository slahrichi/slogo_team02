package slogo.Control;

import slogo.Model.ModelExceptions;
import slogo.View.Panels.CanvasPanel;

public interface ControllerAPI {

  void parseAndRunCommands(String contents) throws ModelExceptions, CommandException ;
}
