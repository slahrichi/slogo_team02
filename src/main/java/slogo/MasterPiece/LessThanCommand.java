package slogo.MasterPiece;

import slogo.MasterPiece.BooleanOperation;

/**
 * Command that checks if a value is less than the other
 * Class shows an implementation of BooleanOperation abstraction.
 * git commits: https://coursework.cs.duke.edu/compsci308_2022spring/slogo_team02/-/commit/32640eeee0b3465876010f4647da055913bc6302
 * @author Haris Adnan
 */
public class LessThanCommand extends BooleanOperation {


  /**
   * Main Constructor for the class
   *
   * @param values
   */
  public LessThanCommand(double[] values) {
    super(values);
  }

  /**
   * @return 1 if the first value is greater than the second value, 0 if not
   */
  @Override
  public double getValue() {
    if (areSame(getParams()[0], getParams()[1])) {
      return 0.0;
    } else if (getParams()[0] < getParams()[1]) {
      return 1.0;
    } else {
      return 0.0;
    }
  }
}
