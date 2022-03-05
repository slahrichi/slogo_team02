package slogo.Model.Commands.TurtleCommands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 */
public class BackwardCommand extends TurtleCommands {

  public BackwardCommand(double[] values) {
    super(values);
  }

  /**
   * Executes the backwards command by moving the turtle to its current location - param[0] in the
   * direction it is facing
   *
   * @param turtle turtle it executes on
   * @return double value it moved
   * @throws ModelExceptions
   */
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    double angle = turtle.getAngle();
    double newXpos = turtle.getTurtleX() - getParams()[0] * Math.cos(Math.toRadians(angle));
    double newYpos = turtle.getTurtleY() - getParams()[0] * Math.sin(Math.toRadians(angle));
    turtle.changeTurtleLocation(newXpos, newYpos);
    return getValue();
  }
}
