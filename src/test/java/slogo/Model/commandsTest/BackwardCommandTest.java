package slogo.Model.commandsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import slogo.Control.TurtleManager;

import slogo.Control.TurtleManagerException;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.BackwardCommand;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;


class BackwardCommandTest extends CommandTest {
  private double[] input = {50};
  List<Turtle> turtleArray = new ArrayList<Turtle>();
  private TurtleManager manager = new TurtleManager(turtleArray);

  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command backwardCommand = new BackwardCommand(input);
    Turtle thisTurtle = null;
    try {
      thisTurtle = manager.getActiveTurtle();
    } catch (TurtleManagerException e) {
      e.printStackTrace();
    }
    double initialX = thisTurtle.getTurtleX();
    double initialY = thisTurtle.getTurtleY();
    backwardCommand.execute(thisTurtle);
    double finalX =thisTurtle.getTurtleX();
    assertEquals(initialX - input[0] * Math.cos(Math.toRadians(thisTurtle.getAngle())), finalX);
    double finalY = thisTurtle.getTurtleY();
    assertEquals(initialY - input[0] * Math.sin(Math.toRadians(thisTurtle.getAngle())), finalY);
  }
}