package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * just returns a constant pi
 */
public class PiCommand extends MathCommands {

  public PiCommand(double[] params) {
    super(params);
  }

  /**
   * returns pi
   */
  @Override
  public double getValue() {
    return Math.PI;
  }
}