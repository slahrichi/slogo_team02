package slogo.Model.Commands.MathCommands;


public class PiCommand extends MathCommands {

  public PiCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return Math.PI;
  }
}