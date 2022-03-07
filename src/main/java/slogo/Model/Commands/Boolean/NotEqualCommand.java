package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
/**
 * Command that checks if a value is not equal to the other
 * @author Haris Adnan
 */

public class NotEqualCommand extends BooleanOperation{

  public NotEqualCommand(double[] values) {
    super(values);
  }

  /**
   *
   * @return 1 if not equal, 0 if equal
   */
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
