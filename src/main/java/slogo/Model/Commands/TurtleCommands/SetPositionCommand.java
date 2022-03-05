package slogo.Model.Commands.TurtleCommands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 *
 * Set Position command
 */
public class SetPositionCommand extends TurtleCommands {

  private double ret;

  public SetPositionCommand(double[] params) {
    super(params);
  }

  /**
   * executes by setting the location of the turtle to the specified position
   *
   * @param turtle turtle to move
   * @return double how much moved
   * @throws ModelExceptions if out of bounds when moved
   */
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

  /**
   * Return distance moved. Doesn't work well though because needs to call execute first
   *
   * @return distance moved
   */
  @Override
  public double getValue() {
    return ret;
  }
}
