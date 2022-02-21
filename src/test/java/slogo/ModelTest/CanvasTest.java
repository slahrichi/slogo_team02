package slogo.ModelTest;

import static java.awt.Color.BLACK;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Model.Canvas;
import slogo.Model.Pen;
import javafx.scene.paint.Color;

class CanvasTest {


  @Test
  void createLineTest() {
    Pen testPen = new Pen(Color.BLACK,false, 1, 50.0, 50.0);
    Canvas testCanvas = new Canvas(100.0, 100.0, Color.WHITE);
    testCanvas.createLine(testPen, 50.0, 50.0, 75.0, 75.0);
    Line lineCreated = testCanvas.allLines.get(0);
    assertEquals(lineCreated.getStartX(), 50.0);
    assertEquals(lineCreated.getStartY(), 50.0);
    assertEquals(lineCreated.getEndX(), 75.0);
    assertEquals(lineCreated.getEndX(), 75.0);
  }

  @Test
  void removeLinesTest() {
    Pen testPen = new Pen(Color.BLACK,false, 1, 50.0, 50.0);
    Canvas testCanvas = new Canvas(100.0, 100.0, Color.WHITE);
    testCanvas.createLine(testPen, 50.0, 50.0, 75.0, 75.0);
    testCanvas.createLine(testPen, 60.0, 60.0, 75.0, 75.0);
//    List<Line> thisArray= testCanvas.allLines;
//    //thisArray.remove
//    List<Line> TestLineList = new ArrayList<Line>();
//    TestLineList.add(testCanvas.allLines.get(0));
//    testCanvas.allLines.removeLines(TestLineList);

  }
}