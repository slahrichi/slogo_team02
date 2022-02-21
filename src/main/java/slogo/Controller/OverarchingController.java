package slogo.Controller;

public class OverarchingController {
  private TurtleHelper turtleHelper;

  public OverarchingController(){
    turtleHelper = new TurtleHelper();
  }

  public TurtleHelper getTurtleHelper(){
    return turtleHelper;
  }
}
