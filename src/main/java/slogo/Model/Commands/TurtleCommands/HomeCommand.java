package slogo.Model.Commands.TurtleCommands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/***
 * @author Mike Keohane
 */
public class HomeCommand extends TurtleCommands {
  public static final double HOME_X = 0;
  public static final double HOME_Y = 0;

  public HomeCommand(double[] empty){
    super(empty);
  }
  private double ret;
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    double ret = calcDistance(turtle);
    turtle.changeTurtleLocation(HOME_X, HOME_Y);
    return ret;
  }

  private double calcDistance(Turtle turtle) {
    return Math.sqrt(
        Math.pow((HOME_X - turtle.getTurtleX()), 2) + Math.pow(
            (HOME_Y - turtle.getTurtleY()), 2));
  }
  @Override
  public double getValue(){
    return ret;
  }
}

