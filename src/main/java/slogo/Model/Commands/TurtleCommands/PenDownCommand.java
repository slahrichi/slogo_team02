package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;
import slogo.Model.Turtle;

public class PenDownCommand extends Command {
  public PenDownCommand(double[] empty){
    super(empty);
  }

  @Override
  public double execute(Turtle turtle){
    turtle.setPenDown();
    return getValue();
  }

  @Override
  public double getValue(){
    return 1;
  }
}

