package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class SetTowardsCommand extends Command {

  public SetTowardsCommand(double[] params) {
    super(params);
  }


  @Override
  public double execute(Turtle turtle) {
    double ret = Math.abs(calcAngle(turtle) - turtle.getAngle());
    turtle.setAngle(calcAngle(turtle));
    return ret;
  }

  private double calcAngle(Turtle turtle) {
    return Math.toDegrees(Math.atan((getParams()[1] - turtle.getTurtleY())/(getParams()[0] - turtle.getTurtleX())));
  }
//  @Override
//  public double getValue(){
//    return getParams()[0] - turt.getAngle();
//  }

}
