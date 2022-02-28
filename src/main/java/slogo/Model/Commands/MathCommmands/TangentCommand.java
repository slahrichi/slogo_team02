package slogo.Model.Commands.MathCommmands;


public class TangentCommand extends MathCommands {

  public TangentCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.tan(Math.toRadians(getParams()[0]));
  }
}
