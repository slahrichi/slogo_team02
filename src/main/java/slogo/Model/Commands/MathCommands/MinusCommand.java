package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 *
 * Minus Command
 */
public class MinusCommand extends MathCommands {

  public MinusCommand(double[] parameters) {
    super(parameters);
  }

  /**
   * Gets value of -1 * parameter
   * @return negative param[0]
   */
  @Override
  public double getValue() {
    return -1 * getParams()[0];
  }


//  @Override
//  public String toString() {
//    return ("Minus " + getValue());
//  }
}
