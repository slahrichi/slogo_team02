package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 *
 * Quotient Command
 */
public class QuotientCommand extends MathCommands {

  public QuotientCommand(double[] params) {
    super(params);
  }

  /**
   * Returns the result of param[0] / param[1]
   * @return quotient of params
   */
  @Override
  public double getValue() {
    return getParams()[0] / getParams()[1];
  }

//  @Override
//  public String toString() {
//    return ("Quotient " + getValue());
//  }
}

