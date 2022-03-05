package slogo.Model.Commands.Boolean;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * Abstract class for boolean operations that extends from command and uses the execute method
 * @author Haris Adnan
 */
public abstract class BooleanOperation extends Command {

  /**
   * Main Constructor
   * @param values
   */
  public BooleanOperation(double[] values) {
    super(values);
  }

  /**
   * execute method that is overriden by subclasses
   * @param turtle
   * @return double
   * @throws ModelExceptions
   */
  public double execute(Turtle turtle) throws ModelExceptions{
    return getValue();
  }

  protected boolean areSame(double a, double b)
  {
    return Math.abs(a - b) < 0.0001;
  }
  protected double nonZero(double a){
    if (areSame(a, 0.000)){
      return 0.0;
    }
    else{
      return 1.0;
    }
  }
}


