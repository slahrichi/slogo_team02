package slogo.Model;

import javafx.scene.paint.Color;
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
   * @param penDown : the boolean value of if the pen is down
   * @param size : size of the pen
   */
  public Pen( boolean penDown, int size) {

    this.myPenDown = penDown;
    this.myPenSize = size;;

  }

  /**
   * checks if pen is up or down
   * @return boolean value relating to if the oen is up or down
   */
  public boolean isMyPenDown() {
    return this.myPenDown;
  }

  /**
   * sets pen up or down
   * @param penDown true or false value relating to if the new value should be up or down
   */
  public void setPenDown(boolean penDown) {
    this.myPenDown = penDown;
  }

  /**
   * gets size of pen, in integers
   * @return size of pen
   */
  public int getPenSize() {
    return this.myPenSize;
  }

  /**
   * sets size of pen
   * @param writingSize: integer that sets the size of pen
   */
  public void setPenSize(int writingSize) {
    this.myPenSize = writingSize;
  }


}
