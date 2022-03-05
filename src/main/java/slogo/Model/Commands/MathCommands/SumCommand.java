package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * Sum Command
 */
public class SumCommand extends MathCommands {

  public SumCommand(double[] params) {
    super(params);
  }

  /**
   * Calculates the sum of the inputs
   *
   * @return sum of the inputs
   */
  @Override
  public double getValue() {
    double ret = 0;
    for (double params : getParams()) {
      ret += params;
    }
    return ret;
  }

//  @Override
//  public String toString() {
//    return ("Sum " + getValue());
//  }
}
