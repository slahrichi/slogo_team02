package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

/**
 * Class for PenUpOrDown Query
 * @author Haris Adnan
 */
public class PenUpOrDown extends TurtleQueries{

  /**
   * PenUpOrDown constructor that extends from the abstract class
   * @param turtle : the turtle that the query is passed on
   */
  public PenUpOrDown(Turtle turtle) {
    super(turtle);
  }

  /**
   * returns integers based off of what the beoolean value of the pen up or down is
   * @return 1 if pen down , 0 if pen up
   */
  public int penUpOrDown(){
    if( myTurtle.isPenDown()){
      return 1;
    }
    else{return 0;}
  }

}
