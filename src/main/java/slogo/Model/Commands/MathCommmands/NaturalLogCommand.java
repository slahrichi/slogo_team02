package slogo.Model.Commands.MathCommmands;


public class NaturalLogCommand extends MathCommands {

  public NaturalLogCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.log(getParams()[0]);
  }
}
