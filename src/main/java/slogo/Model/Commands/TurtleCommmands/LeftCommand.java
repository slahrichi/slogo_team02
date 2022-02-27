package slogo.Model.Commands.TurtleCommmands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class LeftCommand extends Command {

  public LeftCommand(double[] value){
    super(value);
  }

  @Override
  public double execute(Turtle turtle){
    turtle.setAngle(turtle.getAngle() - getParams()[0]);
    return getValue();
  }

  @Override
  public String toString(){
    return ("Left " + getValue());
  }

}

