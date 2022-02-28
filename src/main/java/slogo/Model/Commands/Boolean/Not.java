package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class Not extends BooleanOperation {


  public Not(double[] values) {
    super(values);
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    if (nonZero(getParams()[0]) == 1.0) {
      return 0.0;
    } else {
      return 1.0;
    }
  }
}
