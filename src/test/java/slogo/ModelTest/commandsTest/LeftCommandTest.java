package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Control.InputParser;
import slogo.Control.TurtleManager;
import slogo.Model.commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.commands.*;

class LeftCommandTest extends CommandTest {

  private double[] input = {45};
  private InputParser parser = new InputParser();
  private TurtleManager manager = new TurtleManager(parser);

  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command leftCommand = new LeftCommand(input, manager);
    double initialAngle = manager.getCurrentTurtle().getAngle();
    leftCommand.execute();
    double finalAngle = manager.getCurrentTurtle().getAngle();
    assertEquals(initialAngle - input[0] , finalAngle);
  }
}