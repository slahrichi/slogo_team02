package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Controller.TurtleManager;
import slogo.Model.Command;
import slogo.Model.commands.*;

class RightCommandTest extends CommandTest {

  private double[] input = {45};
  private TurtleManager manager = new TurtleManager();

  @Override
  @Test
  void testExecute() {
    Command rightCommand = new RightCommand(input, manager);
    double initialAngle = manager.getCurrentTurtle().getAngle();
    rightCommand.execute();
    double finalAngle = manager.getCurrentTurtle().getAngle();
    assertEquals(initialAngle + input[0] , finalAngle);
  }
}