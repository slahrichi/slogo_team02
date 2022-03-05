package slogo.Model.Commands;
/**
 * @author Mike Keohane The abstract class that defines all base methods. All commands extend this
 * class.
 */

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public abstract class Command implements CommandAPI {

  private double[] parameters;

  /**
   * Initializes the command based on the inputed parameters
   * @param values parameters used for the command
   */
  public Command(double[] values) {
    parameters = values;
  }

  /**
   * gets the params. Used each of the subclasses
   * @return double[] params
   */
  protected double[] getParams() {
    return parameters;
  }

  /**
   * Executes the command
   * @param turtle
   * @return
   * @throws ModelExceptions
   */
  public abstract double execute(Turtle turtle) throws ModelExceptions;

  /**
   * Returns the value that would be executed
   * @return double value that would be executed
   */
  public abstract double getValue();
}

