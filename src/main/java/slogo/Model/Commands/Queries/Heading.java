package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

public class Heading extends TurtleQueries{

  public Heading(Turtle turtle) {
    super(turtle);
  }
  public double getHeading(){
    return myTurtle.getAngle();
  }

}
