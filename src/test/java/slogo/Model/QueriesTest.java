package slogo.Model;
import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Queries.Heading;
import slogo.Model.Commands.Queries.PenShowing;
import slogo.Model.Commands.Queries.PenUpOrDown;
import slogo.Model.Commands.Queries.XCor;
import slogo.Model.Commands.Queries.YCor;

/**
 * Class that Tests the Query methods in the query package
 * @author Haris Adnan
 */
public class QueriesTest {

  /**
   * test for the getHeading (angle) method
   */
  @Test
  void Heading(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(true, 1), 0);
    Heading heading = new Heading(testTurtle);
    assertEquals(heading.getHeading(), 270.0 );
  }

  /**
   * test to check if the penshowing command is working
   */
  @Test
  void PenShowing(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(true, 1), 0);
    PenShowing penShowing = new PenShowing(testTurtle);
    assertEquals(1, penShowing.isTurtleShowing());

  }
  /**
   * test to check if the PenUpOrDown command is working
   */
  @Test
  void PenUpOrDown(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(true, 1), 0);
    PenUpOrDown penUpOrDown = new PenUpOrDown(testTurtle);
    assertEquals(1, penUpOrDown.penUpOrDown());

  }
  /**
   * test to check if the XCor command is working
   */
  @Test
  void XCor(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen( true, 1), 0);
    XCor xcor = new XCor(testTurtle);
    assertEquals(xcor.getXCor(), -750);
  }
  /**
   * test to check if the YCor command is working
   */
  @Test
  void YCor(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(true, 1), 0);
    YCor ycor = new YCor(testTurtle);
    assertEquals(ycor.getYCor(), -500);
  }

}
