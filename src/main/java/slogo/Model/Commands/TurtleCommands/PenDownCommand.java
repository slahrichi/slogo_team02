package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * Command that sets pen to down
 */
public class PenDownCommand extends TurtleCommands {

  public PenDownCommand(double[] empty) {
    super(empty);
  }

  /**
   * Executes by setting boolean of turtle's pen down to true
   *
   * @param turtle turtle that we want to set pen down
   * @return 1
   */
  @Override
  public double execute(Turtle turtle) {
    turtle.setPenDown();
    return getValue();
  }

  @Override
  public double getValue() {
    return 1;
  }
}

