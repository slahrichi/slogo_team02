package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Difference Command
 */
public class DifferenceCommand extends MathCommands {

  public DifferenceCommand(double[] params) {
    super(params);
  }

  /**
   * subtracts the second input from the first
   *
   * @return difference in values of params
   */
  @Override
  public double getValue() {
    return getParams()[0] - getParams()[1];
  }


//  @Override
//  public String toString() {
//    return ("Difference " + getValue());
//  }
}
