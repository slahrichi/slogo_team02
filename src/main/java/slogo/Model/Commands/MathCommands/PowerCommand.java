package slogo.Model.Commands.MathCommands;


public class PowerCommand extends MathCommands {

  public PowerCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.pow(getParams()[0], getParams()[1]);
  }
}