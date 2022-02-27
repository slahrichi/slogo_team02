package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

public class YCor extends TurtleQueries{


  public YCor(Turtle turtle) {
    super(turtle);
  }
  public double getYCor(){
    return myTurtle.getTurtleYFromCenter();
  }

}
