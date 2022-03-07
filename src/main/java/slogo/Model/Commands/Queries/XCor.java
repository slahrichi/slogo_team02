package slogo.Model.Commands.Queries;

import slogo.Main;
import slogo.Model.Turtle;
public class XCor extends TurtleQueries{

  private double centerOfScreenX = Main.DEFAULT_SIZE.width/2;

  /**
   * Query Class that gets the X coordinate of the turtle from the center of the screen.
   * @author Haris Adnan
   */
  public XCor(Turtle turtle) {
    super(turtle);
  }

  /**
   * gets X coordinate of the Turtle from center of screen, using getTurtleXFromCenter() method
   * @return
   */
  public double getXCor(){
    return getTurtleXFromCenter(myTurtle);
  }
  /**
   * gets X position of turtle from centre of screen
   * @return X coordinate from centre
   */

  public double getTurtleXFromCenter(Turtle turtle){
    double turtleXCor = turtle.getTurtleX();
    if (turtleXCor < centerOfScreenX){
      return -1 *(centerOfScreenX - turtleXCor);
    }
    else if(turtleXCor > centerOfScreenX) {
      return turtleXCor - centerOfScreenX;
    }
    else{
      return 0.0;
    }
  }

}
