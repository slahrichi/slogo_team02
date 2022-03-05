package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * <p>
 * another level of abstraction for the Math commands from Command
 */
public abstract class MathCommands extends Command {

  /**
   * initializes the math command based on the input
   *
   * @param parameters double[] of parameters to do the math on
   */
  public MathCommands(double[] parameters) {
    super(parameters);
  }

  /**
   * Overriden to just return the getvalue. Most of these commands will not actually be executed.
   *
   * @param turtle turtle to keep the abstraction (not used)
   * @return double of calculated value
   * @throws ModelExceptions
   */
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    return getValue();
  }
}
