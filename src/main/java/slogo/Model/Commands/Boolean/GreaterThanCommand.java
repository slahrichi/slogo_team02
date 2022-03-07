package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
/**
 * Command that checks if a value is greater than the other
 * @author Haris Adnan
 */
public class GreaterThanCommand extends BooleanOperation{

  /**
   * Main Constructor for the class
   * @param values
   */
  public GreaterThanCommand(double[] values) {
    super(values);
  }

  /**
   *
   * @return 1 if the first value is greater than the second value, 0 if not
   */
  @Override
  public double getValue() {
    if( areSame(getParams()[0], getParams()[1])){
      return 0.0;
    }else if(getParams()[0] > getParams()[1]){
      return 1.0;
    }
    else{
      return 0.0;
    }
  }
}
