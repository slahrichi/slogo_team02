package slogo.Model;

/**
 * API for teh variable manager that holds the public methods in the VariableManager class.
 * @author harisadnan
 */
public interface VariableManagerAPI {

  /**
   * sets the value of a variable if it already exists or makes a new variable if the variable does not
   * exist
   */
  void setOrMakeVariable();

  /**
   * gets the value of the variable
   * @return value of the variable as double
   */
  double getVariableValue();

  /**
   * makes dummy variable with value as 0.
   * @return: returns the dummy variable
   */
  Variable makeVariableForNoValue();
}
