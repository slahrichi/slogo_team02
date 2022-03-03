package slogo.Model;
import java.awt.Dimension;
import java.util.List;
import slogo.Main;
import slogo.Model.Commands.Command;

/**
 * Class that defines a turtle object
 * @author Haris Adnan
 */
public class Turtle {

  private double myXPos;
  private double myYPos;
  private double myAngle;
  private double myOldXPos;
  private double myOldYPos;
  private double myOldAngle;
  private Pen myPen;


  // Change this to the Bounds of the screen, get from a resource file
  public Dimension BOUNDS= Main.DEFAULT_SIZE;

  // Initiliaze Centre of Screen Coordinates, get from a resource file.
  public final Point CENTER_OF_SCREEN = new Point(500, 600);




  /**
   * Turtle constructor
   * @param Xpos: the X position of the turtle
   * @param Ypos : the Y position of the turtle
   * @param turtleAngle : the heading / angle that the turtle points towards
   * @param pen : the pen associated with the turtle
   */
  public Turtle(double Xpos, double Ypos, double turtleAngle, Pen pen){
    this.myXPos = Xpos;
    this.myYPos = Ypos;
    this.myAngle = turtleAngle;
    this.myOldXPos = Xpos;
    this.myOldYPos = Ypos;
    this.myOldAngle = turtleAngle;
    this.myPen = pen;
  }

  /**
   * the method that gets the headinf og the turtle
   * @return angle of turtle
   */
  public double getAngle() {
    return myAngle;
  }

  /**
   * sets angle of turtle
   * @param angle: new angle that the turtle points to
   */
  public void setAngle(double angle){
    myOldAngle = myAngle;
    myAngle = angle;
  }

  /**
   * gets the old angle that the turtle was pointing towards
   * @return returns the old angle
   */
  public double getOldAngle(){
    return myOldAngle;
  }

  /**
   * returns X position of turtle
   * @return xpos of turtle
   */
  public double getTurtleX(){
    return myXPos;
  }
  /**
   * returns Y position of turtle
   * @return Y pos of turtle
   */
  public double getTurtleY(){
    return myYPos;
  }
  /**
   * returns previous X position of turtle
   * @return previous X pos of turtle
   */
  public double getOldX(){
    return myOldXPos;
  }
  /**
   * returns previous Y position of turtle
   * @return previous Y pos of turtle
   */
  public double getOldY(){
    return myOldYPos;
  }

  /**
   * gets X position of turtle from centre of screen
   * @return x coordinate from centre
   */
  public double getTurtleXFromCenter(){
    double turtleXCor = getTurtleX();
    if (turtleXCor < CENTER_OF_SCREEN.getPointX()){
      return -1 *(CENTER_OF_SCREEN.getPointX() - turtleXCor);
    }
    else if(turtleXCor > CENTER_OF_SCREEN.getPointY()) {
      return turtleXCor - CENTER_OF_SCREEN.getPointY();
    }
    else{
      return 0.0;
    }
  }
  /**
   * gets Y position of turtle from centre of screen
   * @return Y coordinate from centre
   */
  public double getTurtleYFromCenter(){
    double turtleYCor = getTurtleY();
    if (turtleYCor < CENTER_OF_SCREEN.getPointY()){
      return CENTER_OF_SCREEN.getPointY() - turtleYCor;
    }
    else if(turtleYCor > CENTER_OF_SCREEN.getPointY()) {
      return -1 *(turtleYCor - CENTER_OF_SCREEN.getPointY());
    }
    else{
      return 0.0;
    }

  }

  /**
   * Changes the coordinates of the turtle to new X and Y locations
   * @param newXPos : new X coordinate to be set
   * @param newYPos : new Ycoordinate to be set
   * @throws ModelExceptions: the exception to be thrown for when the turtle is moved to a position out of bounds
   */
  public void changeTurtleLocation(double newXPos, double newYPos) throws ModelExceptions {
    if(newXPos > BOUNDS.width || newYPos > BOUNDS.width){
      throw new ModelExceptions("Error with bounds");
    }
    myOldXPos = myXPos;
    myOldYPos = myYPos;
    myXPos = newXPos;
    myYPos = newYPos;
  }

  /**
   * function gets the position of the pen
   * @return boolean value if the pen is down
   */
  public boolean isPenDown() {
    return myPen.isMyPenDown();
  }
  /**
   * function sets the position of the pen as down
   * @return no return value
   */
  public void setPenDown(){
    myPen.setPenDown(true);
  }

  /**
   * function sets the position of the pen as up
   * @return no return value
   */
  public void setPenUp(){
    myPen.setPenDown(false);
  }
  //is turtle showing method need to be implemented in GUI

  /**
   * function returns if the turtle is showing on the screen or not
   * @return boolean value based on if the turtle is showing
   */
  public boolean isTurtleShowing(){
    return true;
  }

  //for testing purposes=
  /**
   * turns the turtle by the amount in parameter
   * @param angle
   */
  public void turn(double angle){myAngle += angle;}


}
