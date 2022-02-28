package slogo.Model;

import javafx.scene.paint.Color;


//The controller class sets teh pen up or down and executes commands on the turtle iteself.
//The turtle and the pen need to be joint.

/**
 * Class that defines the Pen and its characteristics
 * @author Haris Adnan
 */
public class Pen {

  private Color penColor;
  private boolean myPenDown = true;
  private int myPenSize = 1;
  private double myPenX;
  private double myPenY;

  /**
   * Constructor for the pen
   * @param color : color of pen, the color that the pen draws with
   * @param penDown : the boolean value of if the pen is down
   * @param size : size of the pen
   * @param PenX : Pen's X coordinate
   * @param PenY : pen's Y coordinate
   */
  public Pen(Color color, boolean penDown, int size, double PenX, double PenY) {
    this.penColor = color;
    this.myPenDown = penDown;
    this.myPenSize = size;
    this.myPenX = PenX;
    this.myPenY= PenY;

  }

  public Color getPenColor() {
    return this.penColor;
  }
  public void setPenColor(Color color) {
    this.penColor = color;
  }

  public boolean isMyPenDown() {
    return this.myPenDown;
  }
  public void setPenDown(boolean penDown) {
    this.myPenDown = penDown;
  }

  public int getPenSize() {
    return this.myPenSize;
  }
  public void setPenSize(int writingSize) {
    this.myPenSize = writingSize;
  }

//  public void changePenLocation(double newX,double newY){
//    this.myPenX = newX;
//    this.myPenY = newY;
//
//  }

//  private void draw(Command givenCommand){
//    setPenUpOrDown(false);
//    //move the pen so that it draws a line
//
//    setPenUpOrDown(true);
//
//
//  }



}
