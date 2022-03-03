package slogo.Model.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Control.TurtleManager;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.RightCommand;
import slogo.Model.ModelExceptions;

class RightCommandTest extends CommandTest {

  private double[] input = {45};
  private TurtleManager manager = new TurtleManager();

  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command rightCommand = new RightCommand(input);
    double initialAngle = manager.getCurrentTurtle().getAngle();
    rightCommand.execute(manager.getCurrentTurtle());
    double finalAngle = manager.getCurrentTurtle().getAngle();
    assertEquals(initialAngle + input[0] , finalAngle);
  }
}