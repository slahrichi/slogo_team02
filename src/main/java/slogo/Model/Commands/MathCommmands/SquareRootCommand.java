package slogo.Model.Commands.MathCommmands;

public class SquareRootCommand extends MathCommands {

  public SquareRootCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.sqrt(getParams()[0]);
  }
}