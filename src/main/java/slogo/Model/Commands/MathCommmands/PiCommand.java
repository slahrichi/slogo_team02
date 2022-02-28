package slogo.Model.Commands.MathCommmands;


public class PiCommand extends MathCommands {

  public PiCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.PI;
  }
}