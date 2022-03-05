package slogo.Model.Commands.TurtleCommands;


import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * <p>
 * Set Towards Command
 */
public class SetTowardsCommand extends TurtleCommands {

  private double ret;

  public SetTowardsCommand(double[] params) {
    super(params);
  }

  /**
   * executes the turtle by setting its angle to point to the point specified
   *
   * @param turtle turtle to change the angle
   * @return degrees angle changed
   */
  @Override
  public double execute(Turtle turtle) {
    ret = Math.abs(calcAngle(turtle) - turtle.getAngle());
    turtle.setAngle(calcAngle(turtle));
    return ret;
  }

  private double calcAngle(Turtle turtle) {
    return Math.toDegrees(
        Math.atan((getParams()[1] - turtle.getTurtleY()) / (getParams()[0] - turtle.getTurtleX())));
  }

  /**
   * Returns the degrees that the angle changed but doesn't work well because execute needs to be
   * called first
   *
   * @return degrees angle changed
   */
  @Override
  public double getValue() {
    return ret;
  }
}
