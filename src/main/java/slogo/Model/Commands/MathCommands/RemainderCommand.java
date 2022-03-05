package slogo.Model.Commands.MathCommands;

/**
 * @author Mike Keohane
 *
 * Remainder Command
 */
public class RemainderCommand extends MathCommands {

  public RemainderCommand(double[] params) {
    super(params);
  }


  /**
   * Returns the modulo (remainder) of param[0] % param[1]
   * @return result of param[0] % param[1]
   */
  @Override
  public double getValue() {
    return getParams()[0] % getParams()[1];
  }

  @Override
  public String toString() {
    return ("Remainder " + getValue());
  }
}

