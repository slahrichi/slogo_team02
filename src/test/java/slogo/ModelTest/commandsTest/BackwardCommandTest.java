package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Control.TurtleManager;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Commands.*;

class BackwardCommandTest extends CommandTest {
  private double[] input = {50};
  private TurtleManager manager = new TurtleManager();

  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command backwardCommand = new BackwardCommand(input);
    double initialX = manager.getCurrentTurtle().getTurtleX();
    double initialY = manager.getCurrentTurtle().getTurtleY();
    backwardCommand.execute(manager.getCurrentTurtle());
    double finalX = manager.getCurrentTurtle().getTurtleX();
    assertEquals(initialX - input[0] * Math.cos(Math.toRadians(manager.getCurrentTurtle().getAngle())), finalX);
    double finalY = manager.getCurrentTurtle().getTurtleY();
    assertEquals(initialY - input[0] * Math.sin(Math.toRadians(manager.getCurrentTurtle().getAngle())), finalY);
  }
}