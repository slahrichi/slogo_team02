package slogo.Model.Commands.MathCommmands;

public class RemainderCommand extends MathCommands {

  public RemainderCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue() {
    return getParams()[0] % getParams()[1];
  }

  @Override
  public String toString() {
    return ("Remainder " + getValue());
  }
}

