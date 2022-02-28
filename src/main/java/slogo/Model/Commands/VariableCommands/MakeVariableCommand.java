package slogo.Model.Commands.VariableCommands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
import slogo.Model.VariableManager;

//

public class MakeVariableCommand extends Command {
  VariableManager myVariableManager;
  String myVariableName;
  public MakeVariableCommand(String variableName, double[] values, VariableManager VariableManager) {
    super(values);
    myVariableManager = VariableManager;
    myVariableName = variableName;
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    myVariableManager.setOrMakeVariable(myVariableName ,String.valueOf(getParams()[0]));
    return getValue();
  }

  @Override
  public double getValue() {
    return myVariableManager.getVariableValue(String.valueOf(getParams()[0]));
  }

}
