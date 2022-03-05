package slogo.Model.Commands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 * API for the commands
 */
public interface CommandAPI {

  double getValue();

  double execute(Turtle turtle) throws ModelExceptions;
}
