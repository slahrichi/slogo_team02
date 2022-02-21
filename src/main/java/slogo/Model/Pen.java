package slogo.Model;

import javafx.scene.paint.Color;


/**
 * @author Haris Adnan
 */
public class Pen {

  private Color penColor;
  private boolean myPenUp = false;
  private int myPenSize = 1;

  public Pen(Color color, boolean penUp, int size) {

    this.penColor = color;
    this.myPenUp = penUp;
    this.myPenSize = size;

  }

  public Color getPenColor() {
    return this.penColor;
  }

  public boolean isMyPenUp() {
    return this.myPenUp;
  }

  protected void setPenUpOrDown(boolean penUp) {
    this.myPenUp = penUp;
  }

  protected void setPenColor(Color color) {
    this.penColor = color;
  }

  public int getPenSize() {
    return this.myPenSize;
  }

  protected void setPenSize(int writingSize) {
    this.myPenSize = writingSize;
  }

  public void draw(Command givenCommand){
    setPenUpOrDown(false);

    setPenUpOrDown(true);

  }



}
