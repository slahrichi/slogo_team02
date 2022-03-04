package slogo.Model.commandsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import slogo.Control.TurtleManager;
import slogo.Control.TurtleManagerException;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.LeftCommand;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

class LeftCommandTest extends CommandTest {

  private double[] input = {45};
  List<Turtle> turtleArray = new ArrayList<Turtle>();
  private TurtleManager manager = new TurtleManager(turtleArray);


  @Override
  @Test
  void testExecute() throws ModelExceptions {
    Command leftCommand = new LeftCommand(input);
    Turtle thisTurtle  = null;
    try {
      thisTurtle = manager.getActiveTurtle();
    } catch (TurtleManagerException e) {
      e.printStackTrace();
    }
    double initialAngle = thisTurtle.getAngle();
    leftCommand.execute(thisTurtle);
    double finalAngle = thisTurtle.getAngle();
    assertEquals(initialAngle - input[0] , finalAngle);
  }
}