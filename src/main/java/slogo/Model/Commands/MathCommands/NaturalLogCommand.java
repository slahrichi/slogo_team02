package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * natural log command
 */
public class NaturalLogCommand extends MathCommands {

  public NaturalLogCommand(double[] params) {
    super(params);
  }

  /**
   * Calculated the natural log of the param
   *
   * @return natural log of parameter
   */
  @Override
  public double getValue() {
    return Math.log(getParams()[0]);
  }
}
