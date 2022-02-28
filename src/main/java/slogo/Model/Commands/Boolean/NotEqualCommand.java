package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class NotEqualCommand extends BooleanOperation{

  public NotEqualCommand(double[] values) {
    super(values);
  }

  @Override
  public double getValue(){
    if(areSame(getParams()[0], getParams()[1])){
      return 0.0;
    }
    else{
      return 1.0;
    }
  }
}
