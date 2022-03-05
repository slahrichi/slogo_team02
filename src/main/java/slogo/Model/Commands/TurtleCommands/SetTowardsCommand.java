package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class SetTowardsCommand extends TurtleCommands {

  public SetTowardsCommand(double[] params) {
    super(params);
  }

  private double ret;
  @Override
  public double execute(Turtle turtle) {
    ret = Math.abs(calcAngle(turtle) - turtle.getAngle());
    turtle.setAngle(calcAngle(turtle));
    return ret;
  }

  private double calcAngle(Turtle turtle) {
    return Math.toDegrees(Math.atan((getParams()[1] - turtle.getTurtleY())/(getParams()[0] - turtle.getTurtleX())));
  }
  @Override
  public double getValue(){
    return ret;
  }
}
