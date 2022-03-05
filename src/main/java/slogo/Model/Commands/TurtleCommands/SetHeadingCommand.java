package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 *
 * Set Heading Command
 */
public class SetHeadingCommand extends TurtleCommands {

  private double ret;

  public SetHeadingCommand(double[] params) {
    super(params);
  }

  /**
   * Executes by setting the angle to the specified angle
   *
   * @param turtle turtle to move
   * @return degrees rotated
   */
  @Override
  public double execute(Turtle turtle) {
    ret = Math.abs(getParams()[0] - turtle.getAngle());
    turtle.setAngle(getParams()[0]);
    return ret;
  }

  /**
   * Returns the degrees moved, but doesn't work well because you have to call execute first
   *
   * @return double degrees moved
   */
  @Override
  public double getValue() {
    return ret;
  }
}
