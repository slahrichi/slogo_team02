package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Tangent Command
 */
public class TangentCommand extends MathCommands {

  public TangentCommand(double[] params) {
    super(params);
  }

  /**
   * Calculates the tangent of the input in degrees
   *
   * @return tan(param[0])
   */
  @Override
  public double getValue() {
    return Math.tan(Math.toRadians(getParams()[0]));
  }
}
