package slogo.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

class TurtleManagerTest {
  TurtleManager turtleManager = new TurtleManager();

  /**
   * Test to check if the add new turtle Test works. This test uses and tests the getLatestTurtleAddedId()
   * method as well.
   */
  @Test
  void addNewTurtleTest() {
    turtleManager.addNewTurtle(20);
    assertEquals(turtleManager.getLatestTurtleAddedId(), 20);
  }

  @Test
  void changeActiveTurtle() throws TurtleManagerException {
    turtleManager.changeActiveTurtle(0);
    assertEquals(turtleManager.activeTurtle.getTurtleID(), 0);
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

  @Test
  void getRecordTurtle() {
    Turtle thisTurtle = turtleManager.activeTurtle;
    assertEquals(turtleManager.getRecordTurtle(thisTurtle.getTurtleID()) , new TurtleRecord(thisTurtle.getTurtleX(), thisTurtle.getTurtleY(),
        thisTurtle.getAngle(), thisTurtle.isPenDown(), thisTurtle.getOldX(),
        thisTurtle.getOldY(), thisTurtle.getOldAngle(), thisTurtle.getTurtleID()));
  }

  @Test
  void getLatestTurtleAddedId() {
  }

  @Test
  void getTurtleRecord() {
  }

  @Test
  void stepTurtle() {
  }

}