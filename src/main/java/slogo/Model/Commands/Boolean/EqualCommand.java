package slogo.Model.Commands.Boolean;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
/**
 * Command that checks if two values are the same
 * @author Haris Adnan
 */
public class EqualCommand extends BooleanOperation{

  public EqualCommand(double[] values) {
    super(values);
  }

  /**
   *
   * @return 1 if the values are the same, 0 if not
   */
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
