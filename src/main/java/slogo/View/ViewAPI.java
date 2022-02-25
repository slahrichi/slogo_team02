package slogo.View;

import java.lang.reflect.InvocationTargetException;
import slogo.Model.Turtle;

public interface ViewAPI {


  public void clearConsole();


  public void clearDisplay();

  public void clearHistory();


  public void changeBackgroundColor();


  public void displayException(String errorMsg);

  public void sendFileContents(String fileContent)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;


}
