package slogo.Model;
import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Queries.Heading;
import slogo.Model.Commands.Queries.PenShowing;
import slogo.Model.Commands.Queries.PenUpOrDown;
import slogo.Model.Commands.Queries.XCor;
import slogo.Model.Commands.Queries.YCor;

public class QueriesTest {

  @Test
  void Heading(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(Color.BLUE, true, 1), 0);
    Heading heading = new Heading(testTurtle);
    assertEquals(heading.getHeading(), 270.0 );
  }
  @Test
  void PenShowing(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(Color.BLUE, true, 1), 0);
    PenShowing penShowing = new PenShowing(testTurtle);
    assertEquals(1, penShowing.isTurtleShowing());

  }
  @Test
  void PenUpOrDown(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(Color.BLUE, true, 1), 0);
    PenUpOrDown penUpOrDown = new PenUpOrDown(testTurtle);
    assertEquals(1, penUpOrDown.penUpOrDown());

  }
  @Test
  void XCor(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(Color.BLUE, true, 1), 0);
    XCor xcor = new XCor(testTurtle);
    assertEquals(xcor.getXCor(), -750);
  }
  @Test
  void YCor(){
    Turtle testTurtle = new Turtle(0, 0 , 270.0, new Pen(Color.BLUE, true, 1), 0);
    YCor ycor = new YCor(testTurtle);
    assertEquals(ycor.getYCor(), -500);
  }

}
