package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;

/**
 * @author Mike Keohane another level of extraction for just the turtle commands
 */
public abstract class TurtleCommands extends Command {

  public TurtleCommands(double[] params) {
    super(params);
  }

  /**
   * Returns the param[0] unless overriden because most turtle commands just return that
   *
   * @return param[0]
   */
  public double getValue() {
    return getParams()[0];
  }
}
