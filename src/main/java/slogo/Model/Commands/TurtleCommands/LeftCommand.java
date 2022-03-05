package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class LeftCommand extends TurtleCommands {

  public LeftCommand(double[] value){
    super(value);
  }

  @Override
  public double execute(Turtle turtle){
    turtle.setAngle(turtle.getAngle() - getParams()[0]);
    return getValue();
  }


}

