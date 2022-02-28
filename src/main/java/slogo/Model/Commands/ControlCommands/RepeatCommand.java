package slogo.Model.Commands.ControlCommands;

import java.util.List;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class RepeatCommand extends LoopAndConditionalCommands{
  public RepeatCommand(double[] param, List<Command> repeatedCommands){
    super(param, repeatedCommands);
  }

  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    for (int i = 0; i < getParams()[0]; i++){
      for (Command command : getCommandList1()){
        command.execute(turtle);
      }
    }
    return getValue();
  }

  @Override
  public double getValue(){
    return getCommandList1().get(getCommandList1().size()-1).getValue();
  }

  @Override
  public String toString() {
    return "Repeat " + getValue();
  }
}
