package slogo.Model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import slogo.Controller.Command;


/**
 * @author Haris Adnan
 */
public class Pen {

  private Color penColor;
  private boolean myPenUp = false;
  private int myPenSize = 1;
  private double myPenX;
  private double myPenY;

  public Pen(Color color, boolean penUp, int size, double PenX, double PenY) {
    this.penColor = color;
    this.myPenUp = penUp;
    this.myPenSize = size;
    this.myPenX = PenX;
    this.myPenY= PenY;

  }

  public Color getPenColor() {
    return this.penColor;
  }
  protected void setPenColor(Color color) {
    this.penColor = color;
  }

  public boolean isMyPenUp() {
    return this.myPenUp;
  }
  protected void setPenUpOrDown(boolean penUp) {
    this.myPenUp = penUp;
  }

  public int getPenSize() {
    return this.myPenSize;
  }
  protected void setPenSize(int writingSize) {
    this.myPenSize = writingSize;
  }


  private void draw(Command givenCommand){
    setPenUpOrDown(false);
    //move the pen so that it draws a line

    setPenUpOrDown(true);


  }



}
