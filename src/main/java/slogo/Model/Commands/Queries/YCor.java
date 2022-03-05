package slogo.Model.Commands.Queries;

import slogo.Main;
import slogo.Model.Turtle;

public class YCor extends TurtleQueries{

  private double centerOfScreenY = Main.DEFAULT_SIZE.height/2;
  /**
   * Query Class that gets the Y coordinate of the turtle from the center of the screen.
   * @author Haris Adnan
   */
  public YCor(Turtle turtle) {
    super(turtle);
  }
  /**
   * gets Y coordinate of the Turtle from center of screen, using getTurtleYFromCenter() method
   * @return
   */
  public double getYCor(){
    return getTurtleYFromCenter(myTurtle);
  }

  /**
   * gets Y position of turtle from centre of screen
   * @return Y coordinate from centre
   */
  public double getTurtleYFromCenter(Turtle turtle){
    double turtleXCor = turtle.getTurtleX();
    if (turtleXCor < centerOfScreenY){
      return -1 *(centerOfScreenY - turtleXCor);
    }
    else if(turtleXCor > centerOfScreenY) {
      return turtleXCor - centerOfScreenY;
    }
    else{
      return 0.0;
    }
  }

}
