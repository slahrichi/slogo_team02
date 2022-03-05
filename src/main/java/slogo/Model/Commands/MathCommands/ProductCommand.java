package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 * <p>
 * product command
 */
public class ProductCommand extends MathCommands {

  public ProductCommand(double[] params) {
    super(params);
  }

  /**
   * Gets the value of the inputs multiplied together
   *
   * @return params multiplied
   */
  @Override
  public double getValue() {
    double ret = 1;
    for (double param : getParams()) {
      ret *= param;
    }
    return ret;
  }

//  @Override
//  public String toString() {
//    return ("Product " + getValue());
//  }
}

