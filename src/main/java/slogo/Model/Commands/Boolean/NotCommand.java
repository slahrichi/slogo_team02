package slogo.Model.Commands.Boolean;

import slogo.MasterPiece.BooleanOperation;

/**
 * Command that returns the opposite of the value input
 * @author Haris Adnan
 */
public class NotCommand extends BooleanOperation {


  public NotCommand(double[] values) {
    super(values);
  }

  @Override
  public double getValue() {
    if (nonZero(getParams()[0]) == 1.0) {
      return 0.0;
    } else {
      return 1.0;
    }
  }
}
