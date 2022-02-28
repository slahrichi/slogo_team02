package slogo.Model.Commands.ControlCommands;

import java.util.List;
import slogo.Model.Commands.Command;

public abstract class LoopAndConditionalCommands extends Command {
  List<Command> commandList1;
  List<Command> commandList2;

  public LoopAndConditionalCommands(double[] params, List<Command> listCommands1, List<Command> listCommands2){
    super(params);
    commandList1 = listCommands1;
    commandList2 = listCommands2;
  }

  public LoopAndConditionalCommands(double[] params, List<Command> listCommands1){
    super(params);
    commandList1 = listCommands1;
  }

  protected List<Command> getCommandList1(){
    return commandList1;
  }

  protected List<Command> getCommandList2(){
    return commandList2;
  }
}
