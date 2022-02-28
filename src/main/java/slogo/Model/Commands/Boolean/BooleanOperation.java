package slogo.Model.Commands.Boolean;

import slogo.Model.Commands.Command;

public abstract class BooleanOperation extends Command {
  
  public BooleanOperation(double[] values) {
    super(values);
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


