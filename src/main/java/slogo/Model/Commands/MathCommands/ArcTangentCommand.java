package slogo.Model.Commands.MathCommands;


public class ArcTangentCommand extends MathCommands {

  public ArcTangentCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.toDegrees(Math.atan(getParams()[0]));
  }
}