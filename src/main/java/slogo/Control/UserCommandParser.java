package slogo.Control;

import java.util.Stack;
import slogo.Model.Commands.Command;

public class UserCommandParser extends TokenParser {

  public void handle(String token, CommandParser commandParser, Stack commandStack) {
    String currentCommand = commandParser.getSymbol(token);
    commandStack.add(currentCommand);
  }
}
