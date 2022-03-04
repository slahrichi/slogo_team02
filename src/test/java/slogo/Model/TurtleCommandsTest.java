package slogo.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import slogo.Model.TurtleManager;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.BackwardCommand;
import slogo.Model.Commands.TurtleCommands.ForwardCommand;
import slogo.Model.Commands.TurtleCommands.LeftCommand;
import slogo.Model.Commands.TurtleCommands.RightCommand;
import slogo.Model.ModelExceptions;

/*
@author Mike Keohane
 */
class TurtleCommandsTest {
  private TurtleManager manager;
  private double[] input;
  private void setupTest(double[] params){
    manager = new TurtleManager();
    input = params;
  }



  @Test
  void testBackwardsExecute() throws ModelExceptions {
    setupTest(new double[]{50});
    Command backwardCommand = new BackwardCommand(input);
    double initialX = manager.getRecordTurtle().xCord();
    double initialY = manager.getRecordTurtle().yCord();
    manager.stepTurtle(backwardCommand);
    double finalX = manager.getRecordTurtle().xCord();
    assertEquals(initialX - input[0] * Math.cos(Math.toRadians(manager.getRecordTurtle().angle())), finalX);
    double finalY = manager.getRecordTurtle().yCord();
    assertEquals(initialY - input[0] * Math.sin(Math.toRadians(manager.getRecordTurtle().angle())), finalY);
    assertEquals(backwardCommand.getValue(), input[0]);
  }

  @Test
  void testForwardExecute() throws ModelExceptions {
    setupTest(new double[] {50});
    Command forwardCommand = new ForwardCommand(input);
    double initialX = manager.getRecordTurtle().xCord();
    double initialY = manager.getRecordTurtle().yCord();
    manager.stepTurtle(forwardCommand);
    double finalX = manager.getRecordTurtle().xCord();
    assertEquals(initialX + input[0] * Math.cos(Math.toRadians(manager.getRecordTurtle().angle())), finalX);
    double finalY = manager.getRecordTurtle().yCord();
    assertEquals(initialY + input[0] * Math.sin(Math.toRadians(manager.getRecordTurtle().angle())), finalY);
    assertEquals(forwardCommand.getValue(), input[0]);
  }

  @Test
  void testRightExecute() throws ModelExceptions {
    setupTest(new double[] {90});
    Command rightCommand = new RightCommand(input);
    double initialAngle = manager.getRecordTurtle().angle();
    manager.stepTurtle(rightCommand);
    double finalAngle = manager.getRecordTurtle().angle();
    assertEquals(initialAngle + input[0] , finalAngle);
    assertEquals(rightCommand.getValue(), input[0]);
  }

  @Test
  void testLeftExecute() throws ModelExceptions {
    setupTest(new double[] {90});
    Command leftCommand = new LeftCommand(input);
    double initialAngle = manager.getRecordTurtle().angle();
    manager.stepTurtle(leftCommand);
    double finalAngle = manager.getRecordTurtle().angle();
    assertEquals(initialAngle - input[0] , finalAngle);
    assertEquals(leftCommand.getValue(), input[0]);
  }
}