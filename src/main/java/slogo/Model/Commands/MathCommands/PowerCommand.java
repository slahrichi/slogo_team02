package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Power Command
 */
public class PowerCommand extends MathCommands {

  public PowerCommand(double[] params) {
    super(params);
  }

  /**
   * Returns the result of param[0]^param[1]
   *
   * @return power of input 1 on input 2
   */
  @Override
  public double getValue() {
    return Math.pow(getParams()[0], getParams()[1]);
  }
}