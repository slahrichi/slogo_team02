package slogo.Model.Commands.MathCommmands;


public class SineCommand extends MathCommands {

  public SineCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.sin(Math.toRadians(getParams()[0]));
  }
}
