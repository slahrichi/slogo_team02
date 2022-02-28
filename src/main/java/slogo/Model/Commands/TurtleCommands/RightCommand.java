package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class RightCommand extends TurtleCommands {

  public RightCommand(double[] values){
    super(values);
  }

  public double execute(Turtle turtle) {
    turtle.setAngle(turtle.getAngle() + getParams()[0]);
    return getValue();
  }

  @Override
  public String toString(){
    return ("Right " + getParams()[0]);
  }
}
