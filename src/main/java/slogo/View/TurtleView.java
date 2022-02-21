package slogo.View;

import java.util.ResourceBundle;
import slogo.Model.Turtle;

// functionality class of animation, updating the elements

public class TurtleView implements ViewAPI {


  private ResourceBundle myResources;

  public TurtleView(ResourceBundle resources){

    myResources = resources;

    }

  public static void doTest(){

    System.out.println("Testing button works.");

  }


  @Override
  public void updatePosition(Turtle turtle, int xCoord, int yCoord) {

  }

  @Override
  public void clearConsole() {

  }

  @Override
  public void clearDisplay() {

  }

  @Override
  public void clearHistory() {

  }

  @Override
  public void changeBackgroundColor() {

  }

  @Override
  public void displayException(String errorMsg) {

  }

  @Override
  public void sendFileContents(String fileContent) {

  }
}
