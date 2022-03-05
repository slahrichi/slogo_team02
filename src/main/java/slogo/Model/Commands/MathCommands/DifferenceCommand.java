package slogo.Model.Commands.MathCommands;

public class DifferenceCommand extends MathCommands {

  public DifferenceCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue() {
    return getParams()[0] - getParams()[1];
  }

  @Override
  public String toString() {
    return ("Difference " + getValue());
  }

}
