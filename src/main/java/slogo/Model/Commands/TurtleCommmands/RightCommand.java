package slogo.Model.Commands.TurtleCommmands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class RightCommand extends Command {

  public RightCommand(double[] values){
    super(values);
  }

  public double execute(Turtle turtle){
    turtle.setAngle(turtle.getAngle() + getParams()[0]);
    return getParams()[0];
  }
  @Override
  public String toString(){
    return ("Right " + getParams()[0]);
  }
}
