package slogo.Model;
import java.util.ArrayList;
import javafx.scene.shape.Line;

/**
 * @author Haris Adnan
 */
public class Canvas {
  private ArrayList<Line> allLines = new ArrayList<>();
  
  private void createLine(Pen pen, double xPos, double yPos, double newXPos, double newYPos) {
    Line newLine = new Line(xPos, yPos, newXPos, newYPos);
    //do if isMyPenUp is False
    if (!pen.isMyPenUp()) {
      newLine.setStroke(pen.getPenColor());
      newLine.setStrokeWidth(pen.getPenSize());
      allLines.add(newLine);
    }
  }
}
