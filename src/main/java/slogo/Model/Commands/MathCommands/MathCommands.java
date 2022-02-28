package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public abstract class MathCommands extends Command {

  public MathCommands(double[] parameters) {
    super(parameters);
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    return getValue();
  }
}
