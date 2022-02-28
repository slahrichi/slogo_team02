package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class SetPosition extends TurtleCommands {

  public SetPosition(double[] params) {
    super(params);
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    double ret = calcDistance(turtle);
    turtle.changeTurtleLocation(getParams()[0], getParams()[1]);
    return ret;
  }

  private double calcDistance(Turtle turtle) {
    return Math.sqrt(
        Math.pow((getParams()[0] - turtle.getTurtleX()), 2) + Math.pow(
            (getParams()[1] - turtle.getTurtleY()), 2));
  }
}
