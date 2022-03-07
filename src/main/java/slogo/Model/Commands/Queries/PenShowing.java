package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

/**
 * Query Class that checks if the pen is showing
 * @author Haris Adnan
 */
public class PenShowing extends TurtleQueries{

  /**
   * Constructor for the PenShowing Query
   * @param turtle : turtle that the query is passed on
   */
  public PenShowing(Turtle turtle) {
    super(turtle);
  }

  /**
   *  boolean value returned based off if the pen is showing or not.
   * @return 1 if the pen is showing and 0 if the pen is not showing
   */
  public int isTurtleShowing(){
    if(myTurtle.isTurtleShowing()){
      return 1;
    }
    else{return 0;}
  }
}
