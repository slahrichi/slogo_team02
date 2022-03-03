package slogo.View;

import java.lang.reflect.InvocationTargetException;
import slogo.Control.CommandException;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public interface ViewAPI {


  void clearConsole();


  void clearDisplay();

  void clearHistory();


  void changeBackgroundColor();


  void displayException(String errorMsg);

  void sendFileContents(String fileContent)
      throws Exception;

  void notifyHistory();

  void notifyAnimation();
}
