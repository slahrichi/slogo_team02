package slogo.Model.Commands.MathCommands;


public class CosineCommand extends MathCommands {

  public CosineCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.cos(Math.toRadians(getParams()[0]));
  }
}
