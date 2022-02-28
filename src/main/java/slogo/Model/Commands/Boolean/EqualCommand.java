package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class EqualCommand extends BooleanOperation{

  public EqualCommand(double[] values) {
    super(values);
  }

  @Override
  public double getValue(){
    if(areSame(getParams()[0], getParams()[1])){
      return 1.0;
    }
    else{
      return 0.0;
    }
  }

}
