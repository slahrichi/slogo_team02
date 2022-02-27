package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

public class PenUpOrDown extends TurtleQueries{

  public PenUpOrDown(Turtle turtle) {
    super(turtle);
  }
  public int penUpOrDown(){
    if( myTurtle.isPenDown()){
      return 1;
    }
    else{return 0;}
  }

}
