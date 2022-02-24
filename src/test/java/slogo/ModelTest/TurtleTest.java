package slogo.ModelTest;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import slogo.Model.ModelExceptions;
import slogo.Model.Pen;
import slogo.Model.Turtle;

import static org.junit.jupiter.api.Assertions.*;


public class TurtleTest {
  private static final double TOLERANCE = 0.1;
  //List<Command> ListOfCommands = new ArrayList<Command>();

  @Test
  void changeTurtleLocationTestGoodInput() throws ModelExceptions {
    Pen pen = new Pen(Color.BLUE, true, 1, 100.0, 100.0);
    Turtle testTurtle = new Turtle(100, 100, 0.0, 0.0, 0.0, pen);
    double newAngle = 0;
    double changedXPos = 50;
    double changedYPos = 50;
    testTurtle.changeTurtleLocation(changedXPos, changedYPos);
    assertEquals(changedXPos,testTurtle.getTurtleX(), TOLERANCE);
    assertEquals(changedYPos,testTurtle.getTurtleY(), TOLERANCE);
    assertEquals(newAngle,testTurtle.getAngle(), TOLERANCE);
  }
  @Test
  //Test with a location out of bounds, still to implement 
  void changeTurtleLocationTestBadInput(){
    Pen pen = new Pen(Color.BLUE, true, 1, 100.0, 100.0);
    Turtle testTurtle = new Turtle(100, 100, 0.0, 0.0, 0.0, pen);

  }

  @Test
  void turnTestGoodInput(){
    Pen pen = new Pen(Color.BLUE, true, 1, 100.0, 100.0);
    Turtle testTurtle = new Turtle(100, 100, 0.0,0.0,0.0, pen);
    double changedAngle = 90.0;
    testTurtle.turn(90.1);
    assertEquals(changedAngle, testTurtle.getAngle(), TOLERANCE);
  }
  @Test
  void turnTestBadInput(){
    Pen pen = new Pen(Color.BLUE, true, 1, 100.0, 100.0);
    Turtle testTurtle = new Turtle(100, 100, 0.0,0.0,0.0, pen);
    double changedAngle = -90.0;
    testTurtle.turn(- 90);
    assertEquals(changedAngle, testTurtle.getAngle(), TOLERANCE);
  }


}
