package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Controller.InputParser;
import slogo.Controller.TurtleManager;
import slogo.Model.Command;
import slogo.Model.commands.*;

class LeftCommandTest extends CommandTest {

  private double[] input = {45};
  private TurtleManager manager = new TurtleManager();

  @Override
  @Test
  void testExecute() {
    Command leftCommand = new LeftCommand(input, manager);
    double initialAngle = manager.getCurrentTurtle().getAngle();
    leftCommand.execute();
    double finalAngle = manager.getCurrentTurtle().getAngle();
    assertEquals(initialAngle - input[0] , finalAngle);
  }
}