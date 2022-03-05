package slogo.Model.Commands.Queries;

import slogo.Main;
import slogo.Model.Turtle;
public class XCor extends TurtleQueries{

  private double centerOfScreenX = Main.DEFAULT_SIZE.width/2;


  public XCor(Turtle turtle) {
    super(turtle);
  }
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
