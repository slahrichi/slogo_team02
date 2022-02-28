package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class And extends BooleanOperation{

  public And(double[] values) {
    super(values);
  }
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    return nonZero(getParams()[0]) * nonZero(getParams()[1]);
  }
}
