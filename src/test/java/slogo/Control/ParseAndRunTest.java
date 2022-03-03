package slogo.Control;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.Control.CommandException;
import slogo.Control.Controller;
import slogo.Control.TurtleManager;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.ControlCommands.RepeatCommand;
import slogo.Model.ModelExceptions;
import slogo.View.Panels.CanvasPanel;
import slogo.View.ViewAPI;
import slogo.View.slogoGUI;
import util.DukeApplicationTest;

class ParseAndRunTest extends DukeApplicationTest {
  private Controller controller;
  private TurtleManager manager;
//  private void setupTest(){
//    controller = new Controller();
//    manager = controller.getTurtleManager();
//  }
  @Override
  public void start(Stage stage){
    ViewAPI view = new slogoGUI(stage, "English");
    controller = new Controller(view);
    manager = controller.getTurtleManager();
  }

  @Test
  void forwardFifty()
      throws ModelExceptions, CommandException{
    String inputs = "fd 50";
    double initialX = manager.getRecordTurtle().xCord();
    double initialY = manager.getRecordTurtle().yCord();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialX + 50 * Math.cos(Math.toRadians(manager.getRecordTurtle().angle())), manager.getRecordTurtle().xCord());
    assertEquals(initialY + 50 * Math.sin(Math.toRadians(manager.getRecordTurtle().angle())), manager.getRecordTurtle().yCord());
  }

  @Test
  void forwardFiftyRightNinetyForwardFifty()
      throws ModelExceptions, CommandException{
    String inputs = "fd 50 \n rt 90 \n fd 50";
    double initialX = manager.getRecordTurtle().xCord();
    double initialY = manager.getRecordTurtle().yCord();
    double initialAngle = manager.getRecordTurtle().angle();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialAngle + 90, manager.getRecordTurtle().angle());
    assertEquals(initialX + 50, manager.getRecordTurtle().xCord());
    assertEquals(initialY + 50, manager.getRecordTurtle().yCord());
  }

  @Test
  void forwardSumFiftyTwenty()
      throws ModelExceptions, CommandException{
    //setupTest();
    String inputs = "fd sum 50 20";
    double initialX = manager.getRecordTurtle().xCord();
    double initialY = manager.getRecordTurtle().yCord();
    double initialAngle = manager.getRecordTurtle().angle();
    controller.parseAndRunCommands(inputs);
    assertEquals(initialAngle, manager.getRecordTurtle().angle());
    assertEquals(initialX + 70 * Math.cos(Math.toRadians(manager.getRecordTurtle().angle())), manager.getRecordTurtle().xCord());
    assertEquals(initialY + 70 * Math.sin(Math.toRadians(manager.getRecordTurtle().angle())), manager.getRecordTurtle().yCord());
  }

  @Test
  void LessFiftySeventy()
      throws ModelExceptions{
    String inputs = "less 50 70";

   // List<Command> commands = controller.parseAndGetCommands(inputs);
    //assertEquals(1, commands.get(0).execute(manager.getCurrentTurtle()));

  }

  @Test
  void goToXY()
      throws ModelExceptions, CommandException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
   // setupTest();
    String inputs = "goto 8 6";
    controller.parseAndRunCommands(inputs);

   // List<Command> commands = controller.parseAndGetCommands(inputs);
   // System.out.println(commands.get(0).toString());

    assertEquals(8, manager.getRecordTurtle().xCord());
    assertEquals(6, manager.getRecordTurtle().yCord());

  }

  @Test
  void createRandom()
      throws ModelExceptions, CommandException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    //setupTest();
    String inputs = "rand 20";
   // controller.parseAndRunCommandsNoView(inputs);

  //  List<Command> commands = controller.parseAndGetCommands(inputs);
  //  System.out.println(commands.get(0).toString());

   // assertEquals(10, commands.get(0).execute(manager.getCurrentTurtle()));
//    assertEquals(6, manager.getRecordTurtle().yCord());

  }

  @Test
  void repeatFdFifty()
      throws CommandException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ModelExceptions {
  //  setupTest();
    double[] testFive = {5};
    String inputs = "fd 50";
    // controller.parseAndRunCommandsNoView(inputs);
    double initialX = manager.getRecordTurtle().xCord();

   // List<Command> commands = controller.parseAndGetCommands(inputs);
 //   System.out.println(commands.get(0).toString());


    //Command repeatCommand = new RepeatCommand(testFive, commands);
    //repeatCommand.execute(manager.getCurrentTurtle());

     assertEquals(initialX + 5*50, manager.getRecordTurtle().xCord());
//    assertEquals(6, manager.getRecordTurtle().yCord());

  }
}
