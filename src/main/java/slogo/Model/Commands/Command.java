package slogo.Model.Commands;
/**
 * The abstract class that defines all base methods. All commands extend this class.
 */

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public abstract class Command implements CommandAPI{

  private double[] parameters;

  public Command(double[] values) {
    parameters = values;
  }

  protected double[] getParams() {
    return parameters;
  }

  public abstract double execute(Turtle turtle) throws ModelExceptions;

  public abstract double getValue();
}

