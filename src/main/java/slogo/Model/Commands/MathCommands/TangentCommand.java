package slogo.Model.Commands.MathCommands;


public class TangentCommand extends MathCommands {

  public TangentCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.tan(Math.toRadians(getParams()[0]));
  }
}
