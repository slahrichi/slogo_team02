package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class SumCommand extends Command {
  public SumCommand(double[] params){
    super(params);
  }
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    return 0;
  }
}
