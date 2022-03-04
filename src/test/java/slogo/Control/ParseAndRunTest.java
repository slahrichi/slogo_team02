package slogo.Control;

import static org.junit.jupiter.api.Assertions.*;


import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.Model.ModelExceptions;
import slogo.View.slogoGUI;
import util.DukeApplicationTest;

/**
 * @auther Mike Keohane
 */
class ParseAndRunTest extends DukeApplicationTest {
  private Controller controller;

  @Override
  public void start(Stage stage){
    slogoGUI view = new slogoGUI(stage, "English");
    controller = new Controller(view);
  }

  @Test
  void forwardFifty()
      throws Exception {
    String inputs = "fd 50";
    double initialX = controller.getRecordTurtle().xCord();
    double initialY = controller.getRecordTurtle().yCord();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialX + 50 * Math.cos(Math.toRadians(controller.getRecordTurtle().angle())), controller.getRecordTurtle().xCord());
    assertEquals(initialY + 50 * Math.sin(Math.toRadians(controller.getRecordTurtle().angle())), controller.getRecordTurtle().yCord());
  }

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
    assertEquals(initialX + 70 * Math.cos(Math.toRadians(controller.getRecordTurtle().angle())), controller.getRecordTurtle().xCord());
    assertEquals(initialY + 70 * Math.sin(Math.toRadians(controller.getRecordTurtle().angle())), controller.getRecordTurtle().yCord());
  }

  @Test
  void tooManyParameters(){
    String input = "fd 50 60 70";
    Exception exception = assertThrows(CommandException.class, () -> controller.parseAndRunCommands(input));

    assertTrue(exception.getMessage().contains("more constants than needed"));
  }

 // @Test
 // void LessFiftySeventy()
  //    throws ModelExceptions{
  //  String inputs = "less 50 70";

   // List<Command> commands = controller.parseAndGetCommands(inputs);
    //assertEquals(1, commands.get(0).execute(manager.getCurrentTurtle()));

//  }

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

//  @Test
//  void createRandom()
//      throws ModelExceptions, CommandException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//    setupTest();
//    String inputs = "rand 20";
//    controller.parseAndRunCommandsNoView(inputs);
//
//    List<Command> commands = controller.parseAndGetCommands(inputs);
//    System.out.println(commands.get(0).toString());
//
//    assertEquals(10, commands.get(0).execute(manager.getCurrentTurtle()));
//    assertEquals(6, manager.getRecordTurtle().yCord());
//
//  }

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
