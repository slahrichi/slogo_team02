package slogo.Model.Commands.MathCommands;


public class MinusCommand extends MathCommands {

  public MinusCommand(double[] parameters) {
    super(parameters);
  }

  @Override
  public double getValue() {
    return -1 * getParams()[0];
  }

  @Override
  public String toString() {
    return ("Minus " + getValue());
  }
}
