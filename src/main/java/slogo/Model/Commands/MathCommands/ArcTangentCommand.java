package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Arc Tangent Command
 */
public class ArcTangentCommand extends MathCommands {

  public ArcTangentCommand(double[] params) {
    super(params);
  }

  /**
   * Calculates and returns the arc tangent of the param[0]
   *
   * @return arctan of parameter
   */
  @Override
  public double getValue() {
    return Math.toDegrees(Math.atan(getParams()[0]));
  }
}