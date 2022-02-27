package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

public class XCor extends TurtleQueries{


  public XCor(Turtle turtle) {
    super(turtle);
  }
  public double getXCor(){
    return myTurtle.getTurtleXFromCenter();
  }

}
