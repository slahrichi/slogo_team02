package slogo.View;

import java.util.ResourceBundle;

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
  public void updatePosition() {

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
}
