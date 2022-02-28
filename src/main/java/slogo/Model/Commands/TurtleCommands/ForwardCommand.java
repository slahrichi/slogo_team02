package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class ForwardCommand extends Command {
  public ForwardCommand(double[] values){
    super(values);
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    double angle = turtle.getAngle();
    double newXpos = turtle.getTurtleX() + getParams()[0] * Math.cos(Math.toRadians(angle));
    double newYpos = turtle.getTurtleY() + getParams()[0] * Math.sin(Math.toRadians(angle));
    turtle.changeTurtleLocation(newXpos, newYpos);
    return getValue();
  }

  @Override
  public String toString(){
    return ("Forward " + getValue());
  }

}
