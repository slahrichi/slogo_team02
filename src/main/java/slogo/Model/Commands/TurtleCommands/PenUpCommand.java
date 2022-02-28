package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class PenUpCommand extends TurtleCommands {
  public PenUpCommand(double[] empty){
    super(empty);
  }

  @Override
  public double execute(Turtle turtle){
    turtle.setPenUp();
    return getValue();
  }

  @Override
  public double getValue(){
    return 0;
  }
}

