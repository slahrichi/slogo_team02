package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * Command that multiples two given values
 * @author Haris Adnan
 */
public class AndCommand extends BooleanOperation{

  public AndCommand(double[] values) {
    super(values);
  }

  @Override
  public double getValue() {
    return nonZero(getParams()[0]) * nonZero(getParams()[1]);
  }
}
