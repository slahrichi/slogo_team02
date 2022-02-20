package slogo.ModelTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import slogo.Controller.Command;
import slogo.Model.Turtle;

import static org.junit.jupiter.api.Assertions.*;


public class TurtleTest {
  private static final double TOLERANCE = 0.1;
  List<Command> ListOfCommands = new ArrayList<Command>();

  @Test
  void changeTurtleLocationTestGoodInput(){
    Turtle testTurtle = new Turtle(100, 100, ListOfCommands, 0.0);
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
    Turtle testTurtle = new Turtle(100, 100, ListOfCommands, 0.0);

  }

  @Test
  void turnTestGoodInput(){
    Turtle testTurtle = new Turtle(100, 100, ListOfCommands, 0.0);
    double changedAngle = 90.0;
    testTurtle.turn(90.1);
    assertEquals(changedAngle, testTurtle.getAngle(), TOLERANCE);
  }
  @Test
  void turnTestBadInput(){
    Turtle testTurtle = new Turtle(100, 100, ListOfCommands, 0.0);
    double changedAngle = -90.0;
    testTurtle.turn(- 90);
    assertEquals(changedAngle, testTurtle.getAngle(), TOLERANCE);
  }






}
