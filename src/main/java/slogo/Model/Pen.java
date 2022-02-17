package slogo.Model;

import javafx.scene.paint.Paint;

/**
 * @author Haris Adnan
 */
public class Pen {

  private Color penColor;
  private boolean penUp = false;
  private int penSize = 1;

  public Pen(Color color) {
    this.penColor = color;
  }

  public Color getPenColor() {
    return this.penColor;
  }

  public boolean isMyPenUp() {
    return this.penUp;
  }

  protected void setPenCond(boolean penUp) {
    this.penUp = penUp;
  }

  protected void setPenColor(Color color) {
    this.penColor = color;
  }

  public int getPenSize() {
    return this.penSize;
  }

  protected void setPenSize(int writingSize) {
    this.penSize = writingSize;
  }


}
