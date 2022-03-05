package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

/**
 * Abstract class that is used to make Turtle Queries
 * @author Haris Adnan
 */
public abstract class TurtleQueries {
  protected Turtle myTurtle;
  public TurtleQueries(Turtle turtle){
    myTurtle = turtle;
  }


}
