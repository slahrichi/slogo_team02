package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Cosine Command
 */
public class CosineCommand extends MathCommands {

  public CosineCommand(double[] params) {
    super(params);
  }

  /**
   * Calculates the cosine of the parameter in degrees
   *
   * @return cosing of parameter in degrees
   */
  @Override
  public double getValue() {
    return Math.cos(Math.toRadians(getParams()[0]));
  }
}
