package slogo.Model.Commands.ControlCommands;

import java.util.List;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

/**
 * @author Mike Keohane
 *
 * Repeat Command
 */
public class RepeatCommand extends LoopAndConditionalCommands{
  public RepeatCommand(double[] param, List<Command> repeatedCommands){
    super(param, repeatedCommands);
  }

  /**
   * Executes by executing all the list of commands for the specified amount of times
   * @param turtle turtle to execute on
   * @return double result of last command execute
   * @throws ModelExceptions
   */
  @Override
  public double execute(Turtle turtle) throws ModelExceptions {
    for (int i = 0; i < getParams()[0]; i++){
      for (Command command : getCommandList1()){
        command.execute(turtle);
      }
    }
    return getValue();
  }

  /**
   * Value of last command in loops value
   * @return LastCommandInLoop.getValue()
   */
  @Override
  public double getValue(){
    return getCommandList1().get(getCommandList1().size()-1).getValue();
  }

//  @Override
//  public String toString() {
//    return "Repeat " + getValue();
//  }
}
