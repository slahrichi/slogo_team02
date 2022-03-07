package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;
/**
 * Query Class that gets the angle of the turtle
 * @author Haris Adnan
 */
public class Heading extends TurtleQueries{
  /**
   * Constructor for the PenShowing Query
   * @param turtle : turtle that the query is passed on
   */
  public Heading(Turtle turtle) {
    super(turtle);
  }

  /**
   * gettter for the angle of the turtle
   * @return double value representing the turtle angle
   */
  public double getHeading(){
    return myTurtle.getAngle();
  }

}
