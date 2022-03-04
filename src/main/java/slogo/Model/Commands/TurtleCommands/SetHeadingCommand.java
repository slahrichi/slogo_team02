package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Turtle;

public class SetHeadingCommand extends TurtleCommands{

  public SetHeadingCommand(double[] params){
    super(params);
  }

  private double ret;
  @Override
  public double execute(Turtle turtle){
    ret = Math.abs(getParams()[0] - turtle.getAngle());
    turtle.setAngle(getParams()[0]);
    return ret;
  }

  @Override
  public double getValue(){
   return ret;
  }
}
