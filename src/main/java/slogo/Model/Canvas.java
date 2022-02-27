package slogo.Model;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * @author Haris Adnan
 */
public class Canvas {
  //make private
  public ArrayList<Line> allLines = new ArrayList<>();
  private double height;
  private double width;
  private Color screenColor;

  public Canvas(double canvasHeight, double canvasWidth, Color canvasColor){
    width = canvasWidth;
    height = canvasHeight;
    screenColor = canvasColor;
  }
  //make private
  public void createLine(Pen pen, double xPos, double yPos, double newXPos, double newYPos) {
    Line newLine = new Line(xPos, yPos, newXPos, newYPos);
    //do if isMyPenUp is False
    if (!pen.isMyPenDown()) {
      newLine.setStroke(pen.getPenColor());
      newLine.setStrokeWidth(pen.getPenSize());
      allLines.add(newLine);
      //pass the coordinates of these lines onto view or add them to a scene
    }
  }
  protected double getHeight() {
    return height;
  }
  protected double getWidth() {
    return width;
  }
  public void clearLines(){
    allLines.clear();
  }
  //make protected
  public void removeLines(List<Line> LinesToRemove){
    for (Line line:LinesToRemove){
      allLines.remove(line);
    }
  }

}
