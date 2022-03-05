package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * square root command
 */
public class SquareRootCommand extends MathCommands {

  public SquareRootCommand(double[] params) {
    super(params);
  }

  /**
   * Calculates the square root of the parameter
   *
   * @return sqrt(param[0])
   */
  @Override
  public double getValue() {
    return Math.sqrt(getParams()[0]);
  }
}