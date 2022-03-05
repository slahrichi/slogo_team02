package slogo.Model.Commands.ControlCommands;

import java.util.List;
import slogo.Model.Commands.Command;

/**
 * @author Mike Keohane
 * <p>
 * Abstract class to implement loop and conditional commands. Extends comand
 */
public abstract class LoopAndConditionalCommands extends Command {

  List<Command> commandList1;
  List<Command> commandList2;

  /**
   * Initializes the command using double[] params and two lists for the commands that need it (if)
   *
   * @param params        double[] parameters
   * @param listCommands1 first list of commands
   * @param listCommands2 second list of commands
   */
  public LoopAndConditionalCommands(double[] params, List<Command> listCommands1,
      List<Command> listCommands2) {
    super(params);
    commandList1 = listCommands1;
    commandList2 = listCommands2;
  }

  /**
   * Initializes the command for commands that only need one list like repeat
   *
   * @param params        double[] parameters
   * @param listCommands1 list of commands
   */
  public LoopAndConditionalCommands(double[] params, List<Command> listCommands1) {
    super(params);
    commandList1 = listCommands1;
  }

  /**
   * Gets the first list of commands
   *
   * @return list of commands
   */
  protected List<Command> getCommandList1() {
    return commandList1;
  }

  /**
   * Gets the second list of command
   *
   * @return list of commands
   */
  protected List<Command> getCommandList2() {
    return commandList2;
  }
}
