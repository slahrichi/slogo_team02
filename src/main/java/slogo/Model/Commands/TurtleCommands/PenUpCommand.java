package slogo.Model.Commands.TurtleCommands;


import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * pen up command
 */
public class PenUpCommand extends TurtleCommands {

  public PenUpCommand(double[] empty) {
    super(empty);
  }

  /**
   * Executes by setting boolean of turtle's pen down to false by calling setPenUp()
   *
   * @param turtle turtle that we want to set pen up
   * @return 0
   */
  @Override
  public double execute(Turtle turtle) {
    turtle.setPenUp();
    return getValue();
  }

  @Override
  public double getValue() {
    return 0;
  }
}

