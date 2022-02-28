package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class OrCommand extends BooleanOperation{

  public OrCommand(double[] values) {
    super(values);
  }

  @Override
  public double getValue() {
    if (nonZero(getParams()[0]) == 1.0 || nonZero(getParams()[1]) == 0.0){
      return 1.0;
    }
    else{
      return 0.0;
    }
  }
}
