package slogo.Model.Commands.MathCommmands;


public class QuotientCommand extends MathCommands {

  public QuotientCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue() {
    return getParams()[0] / getParams()[1];
  }

  @Override
  public String toString() {
    return ("Quotient " + getValue());
  }
}

