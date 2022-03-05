package slogo.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.*;

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


  /*
  Tests Backwards Command
   */
  @Test
  void testBackwardsExecute() throws ModelExceptions {
    setupTest(new double[]{50});
    Command backwardCommand = new BackwardCommand(input);
    double initialX = manager.getRecordTurtle(0).xCord();
    double initialY = manager.getRecordTurtle(0).yCord();
    manager.stepTurtle(backwardCommand);
    double finalX = manager.getRecordTurtle(0).xCord();
    assertEquals(initialX - input[0] * Math.cos(Math.toRadians(manager.getRecordTurtle(0).angle())),
        finalX);
    double finalY = manager.getRecordTurtle(0).yCord();
    assertEquals(initialY - input[0] * Math.sin(Math.toRadians(manager.getRecordTurtle(0).angle())),
        finalY);
    assertEquals(backwardCommand.getValue(), input[0]);
  }

  /*
 Tests Forwards Command
  */
  @Test
  void testForwardExecute() throws ModelExceptions {
    setupTest(new double[]{50});
    Command forwardCommand = new ForwardCommand(input);
    double initialX = manager.getRecordTurtle(0).xCord();
    double initialY = manager.getRecordTurtle(0).yCord();
    manager.stepTurtle(forwardCommand);
    double finalX = manager.getRecordTurtle(0).xCord();
    assertEquals(initialX + input[0] * Math.cos(Math.toRadians(manager.getRecordTurtle(0).angle())),
        finalX);
    double finalY = manager.getRecordTurtle(0).yCord();
    assertEquals(initialY + input[0] * Math.sin(Math.toRadians(manager.getRecordTurtle(0).angle())),
        finalY);
    assertEquals(forwardCommand.getValue(), input[0]);
  }

  /*
  Test forwards expects Model exception
   */
  @Test
  void testForwardBadExecuteException() {
    setupTest(new double[]{50000});
    Command forwardCommand = new ForwardCommand(input);

    Exception exception = assertThrows(ModelExceptions.class, () -> manager.stepTurtle(forwardCommand));

    String expectedMessage = "Error with bounds";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }
  /*
 Tests Right Command
  */
  @Test
  void testRightExecute() throws ModelExceptions {
    setupTest(new double[]{90});
    Command rightCommand = new RightCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(rightCommand);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals((initialAngle + input[0])%360, finalAngle);
    assertEquals(rightCommand.getValue(), input[0]);
  }

  /*
 Tests Left Command
  */
  @Test
  void testLeftExecute() throws ModelExceptions {
    setupTest(new double[]{90});
    Command leftCommand = new LeftCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(leftCommand);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals((initialAngle - input[0])%360, finalAngle);
    assertEquals(leftCommand.getValue(), input[0]);
  }

  /*
  Tests home command, but isn't good because in order for getValue() to work, it needs to be executed first
   */
  @Test
  void testHomeCommand() throws ModelExceptions {
    setupTest(new double[]{});
    Command homeCommand = new HomeCommand(input);
    double initialX = manager.getRecordTurtle(0).xCord();
    double initialY = manager.getRecordTurtle(0).yCord();
    manager.stepTurtle(homeCommand);
    double finalX = manager.getRecordTurtle(0).xCord();
    double finalY = manager.getRecordTurtle(0).yCord();
    assertEquals(finalX, finalY, 0);
    assertEquals(homeCommand.getValue(),
        Math.sqrt(Math.pow((finalX - initialX), 2) + Math.pow((finalY - initialY), 2)));
  }

  /*
  tests pen down command
   */
  @Test
  void testPenDown() throws ModelExceptions {
    setupTest(new double[]{});
    Command penDown = new PenDownCommand(input);
    manager.stepTurtle(penDown);
    assertEquals(penDown.getValue(), 1);
    assertTrue(manager.getRecordTurtle(0).penDown());
  }

  /*
  Tests pen up command
   */
  @Test
  void testPenUp() throws ModelExceptions {
    setupTest(new double[]{});
    Command penUp = new PenUpCommand(input);
    manager.stepTurtle(penUp);
    assertEquals(penUp.getValue(), 0);
    assertFalse(manager.getRecordTurtle(0).penDown());
  }

  /*
  Test setHeading but isn't good because in order for getValue() to work, it needs to be executed first
   */
  @Test
  void testSetHeading() throws ModelExceptions {
    setupTest(new double[]{180});
    Command setHeading = new SetHeadingCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(setHeading);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals(finalAngle, input[0]);
    assertEquals(setHeading.getValue(), Math.abs(input[0] - initialAngle));
  }

  /*
 Test setHeading but isn't good because in order for getValue() to work, it needs to be executed first
  */
  @Test
  void testSetPosition() throws ModelExceptions {
    setupTest(new double[]{50, 50});
    Command setPosition = new SetPositionCommand(input);
    double initialX = manager.getRecordTurtle(0).xCord();
    double initialY = manager.getRecordTurtle(0).yCord();
    manager.stepTurtle(setPosition);
    double finalX = manager.getRecordTurtle(0).xCord();
    double finalY = manager.getRecordTurtle(0).yCord();
    assertEquals(finalX, input[0]);
    assertEquals(finalY, input[1]);
    assertEquals(setPosition.getValue(),
        Math.sqrt(Math.pow((finalX - initialX), 2) + Math.pow((finalY - initialY), 2)));
  }

  /*
Test setTowards but isn't good because in order for getValue() to work, it needs to be executed first
*/
  @Test
  void testSetTowards() throws ModelExceptions {
    setupTest(new double[]{50, 50});
    Command setTowards = new SetTowardsCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(setTowards);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals(finalAngle, calcAngle(manager.getRecordTurtle(0), input));
    assertEquals(setTowards.getValue(),Math.abs(calcAngle(manager.getRecordTurtle(0),input) -initialAngle));
  }

  private double calcAngle(TurtleRecord turtle, double[] input) {
    return Math.toDegrees(Math.atan((input[1] - turtle.yCord())/(input[0] - turtle.xCord())));
  }
}