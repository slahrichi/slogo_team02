package slogo.Model.Commands.TurtleCommands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class SetPositionCommand extends TurtleCommands {

  public SetPositionCommand(double[] params) {
    super(params);
  }

  private double ret;
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    ret = calcDistance(turtle);
    turtle.changeTurtleLocation(getParams()[0], getParams()[1]);
    return ret;
  }

  private double calcDistance(Turtle turtle) {
    return Math.sqrt(
        Math.pow((getParams()[0] - turtle.getTurtleX()), 2) + Math.pow(
            (getParams()[1] - turtle.getTurtleY()), 2));
  }

  @Override
  public double getValue(){
    return ret;
  }
//  @Override
//  public String toString(){
//    return "SetPos "+ getValue();
//  }
}
