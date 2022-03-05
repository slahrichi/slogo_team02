package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Sine Command
 */
public class SineCommand extends MathCommands {

  public SineCommand(double[] params) {
    super(params);
  }

  /**
   * Returns the sine of the parameter
   *
   * @return sin(param[0])
   */
  @Override
  public double getValue() {
    return Math.sin(Math.toRadians(getParams()[0]));
  }
}
