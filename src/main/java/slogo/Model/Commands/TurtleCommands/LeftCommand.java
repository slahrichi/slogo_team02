package slogo.Model.Commands.TurtleCommands;


import slogo.Model.Turtle;

/**
 * @author Mike Keohane Left Command
 */
public class LeftCommand extends TurtleCommands {

  public LeftCommand(double[] value) {
    super(value);
  }

  /**
   * Executes the command by setting the turtle angle to its angle - param[0]
   *
   * @param turtle turtle to be moved
   * @return amount turned
   */
  @Override
  public double execute(Turtle turtle) {
    turtle.setAngle(turtle.getAngle() - getParams()[0]);
    return getValue();
  }


}

