package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Control.TurtleManager;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Commands.*;

class LeftCommandTest extends CommandTest {

  private double[] input = {45};
  private TurtleManager manager = new TurtleManager();

  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command leftCommand = new LeftCommand(input);
    double initialAngle = manager.getCurrentTurtle().getAngle();
    leftCommand.execute(manager.getCurrentTurtle());
    double finalAngle = manager.getCurrentTurtle().getAngle();
    assertEquals(initialAngle - input[0] , finalAngle);
  }
}