package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class SetHeading extends TurtleCommands{

  public SetHeading(double[] params){
    super(params);
  }

  @Override
  public double execute(Turtle turtle){
    double ret = Math.abs(getParams()[0] - turtle.getAngle());
    turtle.setAngle(getParams()[0]);
    return ret;
  }

//  @Override
//  public double getValue(){
//    return getParams()[0] - turt.getAngle();
//  }
}
