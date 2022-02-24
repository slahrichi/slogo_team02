package slogo.View;

import slogo.Model.Turtle;

public interface ViewAPI {

  public void updatePosition(Turtle turtle);

  public void clearConsole();


  public void clearDisplay();

  public void clearHistory();


  public void changeBackgroundColor();


  public void displayException(String errorMsg);

  public void sendFileContents(String fileContent);


}
