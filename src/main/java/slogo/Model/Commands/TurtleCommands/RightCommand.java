package slogo.Model.Commands.TurtleCommands;


import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * Right command
 */
public class RightCommand extends TurtleCommands {

  public RightCommand(double[] values){
    super(values);
  }

  /**
   * executes by setting the turtle's angle to adding param[0] to the turtle's angle
   * @param turtle turtle to turn
   * @return amount turned
   */
  @Override
  public double execute(Turtle turtle) {
    turtle.setAngle(turtle.getAngle() + getParams()[0]);
    return getValue();
  }

}
