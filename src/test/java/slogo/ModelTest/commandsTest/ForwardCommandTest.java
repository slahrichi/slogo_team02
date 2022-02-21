package slogo.ModelTest.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import slogo.Controller.InputParser;
import slogo.Controller.TurtleManager;
import slogo.Model.Command;
import slogo.Model.commands.*;

class ForwardCommandTest extends CommandTest {

  private double[] input = {50};
  private InputParser parser = new InputParser();
  private TurtleManager manager = new TurtleManager(parser);


  @Override
  @Test
  void testExecute() {
    Command forwardCommand = new ForwardCommand(input, manager);
    double initialX = manager.getCurrentTurtle().getTurtleX();
    double initialY = manager.getCurrentTurtle().getTurtleY();
    forwardCommand.execute();
    double finalX = manager.getCurrentTurtle().getTurtleX();
    assertEquals(initialX + input[0] * Math.cos(Math.toRadians(manager.getCurrentTurtle().getAngle())), finalX);
    double finalY = manager.getCurrentTurtle().getTurtleY();
    assertEquals(initialY + input[0] * Math.sin(Math.toRadians(manager.getCurrentTurtle().getAngle())), finalY);
  }
}