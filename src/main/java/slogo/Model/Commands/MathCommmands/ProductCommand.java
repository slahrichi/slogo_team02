package slogo.Model.Commands.MathCommmands;


public class ProductCommand extends MathCommands {

  public ProductCommand(double[] params) {
    super(params);
  }

  @Override
  public double getValue() {
    return getParams()[0] * getParams()[1];
  }

  @Override
  public String toString() {
    return ("Product " + getValue());
  }
}

