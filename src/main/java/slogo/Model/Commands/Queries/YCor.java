package slogo.Model.Commands.Queries;

import slogo.Main;
import slogo.Model.Turtle;

public class YCor extends TurtleQueries{

  private double centerOfScreenY = Main.DEFAULT_SIZE.height/2;
  public YCor(Turtle turtle) {
    super(turtle);
  }
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
