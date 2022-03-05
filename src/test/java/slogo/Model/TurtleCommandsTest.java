package slogo.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.*;

/**
 * @author Mike Keohane
 */
class TurtleCommandsTest {

  private TurtleManager manager;
  private double[] input;

  private void setupTest(double[] params) {
    manager = new TurtleManager();
    input = params;
  }


  /**
   * Tests Backwards Command for input of 50
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testBackwardsExecute() throws ModelExceptions, TurtleManagerException {
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

  /**
   * Tests Forwards Command for input of 50
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testForwardExecute() throws ModelExceptions, TurtleManagerException {
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

  /**
   * Test to see if Model Exception is thrown if turtle is moved forward outside of the canvas
   */
  @Test
  void testForwardBadExecuteException() {
    setupTest(new double[]{50000});
    Command forwardCommand = new ForwardCommand(input);

    Exception exception = assertThrows(ModelExceptions.class,
        () -> manager.stepTurtle(forwardCommand));

    String expectedMessage = "Error with bounds";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  /**
   * Tests Right Command with input 90
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testRightExecute() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{90});
    Command rightCommand = new RightCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(rightCommand);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals((initialAngle + input[0]) % 360, finalAngle);
    assertEquals(rightCommand.getValue(), input[0]);
  }

  /**
   * Tests Left Command with input 90
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testLeftExecute() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{90});
    Command leftCommand = new LeftCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(leftCommand);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals((initialAngle - input[0]) % 360, finalAngle);
    assertEquals(leftCommand.getValue(), input[0]);
  }

  /**
   * Tests home command, but isn't great because in order for getValue() to work, it needs to be
   * executed first
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testHomeCommand() throws ModelExceptions, TurtleManagerException {
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

  /**
   * Tests pen down command
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testPenDown() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{});
    Command penDown = new PenDownCommand(input);
    manager.stepTurtle(penDown);
    assertEquals(penDown.getValue(), 1);
    assertTrue(manager.getRecordTurtle(0).penDown());
  }

  /**
   * Tests pen up command
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testPenUp() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{});
    Command penUp = new PenUpCommand(input);
    manager.stepTurtle(penUp);
    assertEquals(penUp.getValue(), 0);
    assertFalse(manager.getRecordTurtle(0).penDown());
  }

  /**
   * Tests setHeading but isn't great because in order for getValue() to work, it needs to be
   * executed first
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testSetHeading() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{180});
    Command setHeading = new SetHeadingCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(setHeading);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals(finalAngle, input[0]);
    assertEquals(setHeading.getValue(), Math.abs(input[0] - initialAngle));
  }

  /**
   * Test setHeading but isn't good because in order for getValue() to work, it needs to be executed
   * first
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testSetPosition() throws ModelExceptions, TurtleManagerException {
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

  /**
   * Test setTowards but isn't great because in order for getValue() to work, it needs to be
   * executed first
   *
   * @throws ModelExceptions
   * @throws TurtleManagerException
   */
  @Test
  void testSetTowards() throws ModelExceptions, TurtleManagerException {
    setupTest(new double[]{50, 50});
    Command setTowards = new SetTowardsCommand(input);
    double initialAngle = manager.getRecordTurtle(0).angle();
    manager.stepTurtle(setTowards);
    double finalAngle = manager.getRecordTurtle(0).angle();
    assertEquals(finalAngle, calcAngle(manager.getRecordTurtle(0), input));
    assertEquals(setTowards.getValue(),
        Math.abs(calcAngle(manager.getRecordTurtle(0), input) - initialAngle));
  }

  private double calcAngle(TurtleRecord turtle, double[] input) {
    return Math.toDegrees(Math.atan((input[1] - turtle.yCord()) / (input[0] - turtle.xCord())));
  }
}