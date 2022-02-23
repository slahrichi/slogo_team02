package slogo.Model.commands;

import slogo.Model.Turtle;

public class RightCommand extends Command {

  public RightCommand(double[] values){
    super(values);
  }

  public double execute(Turtle turtle){
    turtle.setAngle(turtle.getAngle() + getParams()[0]);
    return getParams()[0];
  }
}
