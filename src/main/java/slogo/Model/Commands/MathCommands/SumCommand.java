package slogo.Model.Commands.MathCommands;

public class SumCommand extends MathCommands {

  public SumCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return getParams()[0] + getParams()[1];
  }

  @Override
  public String toString() {
    return ("Sum " + getValue());
  }
}
