package slogo.Model.Commands.Queries;

import slogo.Model.Turtle;

public class PenShowing extends TurtleQueries{


  public PenShowing(Turtle turtle) {
    super(turtle);
  }
  public int isTurtleShowing(){
    if(myTurtle.isTurtleShowing()){
      return 1;
    }
    else{return 0;}
  }
}
