package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
/**
 * Command that checks if a value is less than or Equal to the other
 * @author Haris Adnan
 */
public class LessEqualCommand extends BooleanOperation{


  public LessEqualCommand(double[] values) {
    super(values);
  }
  /**
   *
   * @return 1 if the value is lesser than or equal to the other value, 0 if not
   */
  @Override
  public double getValue()  {
    if(areSame(getParams()[0],getParams()[1])){
      return 1.0;
    }
    else if (getParams()[0]<getParams()[1]){
      return 1.0;
    }
    else{return 0.0;}
  }
}
