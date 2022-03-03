package slogo.Model.Commands;

import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public interface CommandAPI {
  double getValue();
  double execute(Turtle turtle) throws ModelExceptions;
}
