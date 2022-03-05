package slogo.Control;

import static org.junit.jupiter.api.Assertions.*;


import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.View.slogoGUI;
import util.DukeApplicationTest;

/**
 * @author Mike Keohane
 * <p>
 * class that runs tests to see if strings can be parsed properly and then the commands executed
 */
class ParseAndRunTest extends DukeApplicationTest {

  private Controller controller;

  @Override
  public void start(Stage stage) {
    slogoGUI view = new slogoGUI(stage, "English");
    controller = new Controller(view);
  }

  /**
   * Tests to see if both the parser can read fd 50 and the turtle move 50
   *
   * @throws Exception
   */
  @Test
  void forwardFifty()
      throws Exception {
    String inputs = "fd 50";
    double initialX = controller.getRecordTurtle().xCord();
    double initialY = controller.getRecordTurtle().yCord();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialX + 50 * Math.cos(Math.toRadians(controller.getRecordTurtle().angle())),
        controller.getRecordTurtle().xCord());
    assertEquals(initialY + 50 * Math.sin(Math.toRadians(controller.getRecordTurtle().angle())),
        controller.getRecordTurtle().yCord());
  }

  /**
   * Tests to see if both the parser can read and the turtle can execute multiple commands
   *
   * @throws Exception
   */
  @Test
  void forwardFiftyRightNinetyForwardFifty()
      throws Exception {
    String inputs = "fd 50 \n rt 90 \n fd 50";
    double initialX = controller.getRecordTurtle().xCord();
    double initialY = controller.getRecordTurtle().yCord();
    double initialAngle = controller.getRecordTurtle().angle();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialAngle + 90, controller.getRecordTurtle().angle());
    assertEquals(initialX + 50, controller.getRecordTurtle().xCord());
    assertEquals(initialY + 50, controller.getRecordTurtle().yCord());
  }

  /**
   * Tests to see if both the parser can read and the turtle can execute multiple commands
   *
   * @throws Exception
   */
  @Test
  void forwardSumFiftyTwenty()
      throws Exception {
    //setupTest();
    String inputs = "fd sum 50 20";
    double initialX = controller.getRecordTurtle().xCord();
    double initialY = controller.getRecordTurtle().yCord();
    double initialAngle = controller.getRecordTurtle().angle();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialAngle, controller.getRecordTurtle().angle());
    assertEquals(initialX + 70 * Math.cos(Math.toRadians(controller.getRecordTurtle().angle())),
        controller.getRecordTurtle().xCord());
    assertEquals(initialY + 70 * Math.sin(Math.toRadians(controller.getRecordTurtle().angle())),
        controller.getRecordTurtle().yCord());
  }

  /**
   * Tests to see if exception is thrown when there are too many parameters
   *
   * @throws Exception
   */
  @Test
  void tooManyParameters() {
    String input = "fd 50 60 70";
    Exception exception = assertThrows(CommandException.class,
        () -> controller.parseAndRunCommands(input));

    assertTrue(exception.getMessage().contains("more constants than needed"));
  }

  /**
   * Tests to see if exception is thrown when there are not enough parameters
   *
   * @throws Exception
   */
  @Test
  void notEnoughParameters() {
    String input = "fd";
    Exception exception = assertThrows(CommandException.class,
        () -> controller.parseAndRunCommands(input));

    assertTrue(exception.getMessage().contains("Not enough constants for"));
  }


  /**
   * Tests to see if the parser can parse goto and if the turtle moves there
   *
   * @throws Exception
   */
  @Test
  void goToXY()
      throws Exception {
    // setupTest();
    String inputs = "goto 8 6";
    controller.parseAndRunCommands(inputs);

    // List<Command> commands = controller.parseAndGetCommands(inputs);
    //  System.out.println(commands.get(0).toString());

    assertEquals(8, controller.getRecordTurtle().xCord());
    assertEquals(6, controller.getRecordTurtle().yCord());

  }

  /**
   * Tests to see if the repeat command works, but we never implemented it
   */
//  @Test
//  void repeatFdFifty()
//      throws CommandException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ModelExceptions {
//    setupTest();
//    double[] testFive = {5};
//    String inputs = "fd 50";
//     controller.parseAndRunCommandsNoView(inputs);
//    double initialX = controller.getRecordTurtle().xCord();
//
//    List<Command> commands = controller.parseAndGetCommands(inputs);
//    System.out.println(commands.get(0).toString());
//
//
//    Command repeatCommand = new RepeatCommand(testFive, commands);
//    repeatCommand.execute(manager.getCurrentTurtle());
//
//     assertEquals(initialX + 5*50, controller.getRecordTurtle().xCord());
//    assertEquals(6, manager.getRecordTurtle().yCord());
//
//  }
}
