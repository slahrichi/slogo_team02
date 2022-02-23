package slogo.Model.commands;

import slogo.Model.Turtle;

public class LeftCommand extends Command {

  public LeftCommand(double[] value){
    super(value);
  }

  @Override
  public double execute(Turtle turtle){
    turtle.setAngle(turtle.getAngle() - getParams()[0]);
    return getParams()[0];
  }
}

