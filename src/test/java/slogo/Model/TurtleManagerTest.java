package slogo.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.TurtleCommands.BackwardCommand;
import slogo.Model.Commands.TurtleCommands.ForwardCommand;

/**
 * The turtle manager class test, that holds all the different turtles tests and contains test commands for update /
 * getting different values from the turtles
 * @author Haris Adnan.
 *
 */
class TurtleManagerTest {
  TurtleManager turtleManager = new TurtleManager();
  private double[] input;
  /**
   * Test to check if the add new turtle Test works. This test uses and tests the getLatestTurtleAddedId()
   * method as well.
   */
  private void setupTest(double[] params){
    input = params;
  }

  /**
   * test checks to see if a turtle is added to turtle lists
   */
  @Test
  void addNewTurtleTest() {
    turtleManager.addNewTurtle(20);
    assertEquals(turtleManager.getLatestTurtleAddedId(), 20);
  }

  /**
   * test checks if changing the active turtle happens, good input
   * @throws TurtleManagerException : exception that handles problems with changing active turtle
   */

  @Test
  void changeActiveTurtleGoodInput() throws TurtleManagerException {
    turtleManager.changeActiveTurtle(0);
    assertEquals(turtleManager.activeTurtle.getTurtleID(), 0);
  }

  /**
   * test checks if changing the active turtle happens,bad input, throws exceptions
   * @throws TurtleManagerException : exception that handles problems with changing active turtle
   */
  @Test
  void changeActiveTurtleBadInput() throws TurtleManagerException{

    assertThrows(TurtleManagerException.class, () -> turtleManager.changeActiveTurtle(100));
  }


  /**
   *  tests if addMultipleTurtles() method works, uses and tests numberOfTurtlesInList() as well
   */
  @Test
  void addMultipleTurtlesTest() {
    List<Integer> testList = new ArrayList<Integer>();
    testList.add(2);
    testList.add(3);
    turtleManager.addMultipleTurtles(testList);
    assertEquals(turtleManager.numberOfTurtlesInList(), 3);
  }

  /**
   * test gets turtle record
   * @throws TurtleManagerException : exception that handles incorrect turtle get.
   */
  @Test
  void getRecordTurtle() throws TurtleManagerException {
    Turtle thisTurtle = turtleManager.activeTurtle;
    assertEquals(turtleManager.getRecordTurtle(thisTurtle.getTurtleID()) , new TurtleRecord(thisTurtle.getTurtleX(), thisTurtle.getTurtleY(),
        thisTurtle.getAngle(), thisTurtle.isPenDown(), thisTurtle.getOldX(),
        thisTurtle.getOldY(), thisTurtle.getOldAngle(), thisTurtle.getTurtleID()));
  }

  /**
   * Tests if the turtle steps correctly
   * @throws ModelExceptions
   */

  @Test
  void stepTurtleTestGoodInput() throws ModelExceptions {
    Turtle thisTurtle = turtleManager.activeTurtle;
    setupTest(new double[]{50});
    Command forward50Command = new ForwardCommand(input);
    turtleManager.stepTurtle(forward50Command);
    assertEquals(thisTurtle.getTurtleY(), -50.0, 0.0001);
  }



}