package slogo.Model;
import java.awt.Dimension;
import java.util.ResourceBundle;
import slogo.Main;

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
  private int myID;
  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String VIEW_RESOURCE_PACKAGE = "view/";
  ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + VIEW_RESOURCE_PACKAGE + "Canvas");
  private final int CANVAS_DIMENSIONS;



  /**
   * Turtle constructor
   * @param Xpos: the X position of the turtle
   * @param Ypos : the Y position of the turtle
   * @param turtleAngle : the heading / angle that the turtle points towards
   * @param pen : the pen associated with the turtle
   */
  public Turtle(double Xpos, double Ypos, double turtleAngle, Pen pen, int turtleID){
    this.myXPos = Xpos;
    this.myYPos = Ypos;
    this.myAngle = turtleAngle;
    this.myOldXPos = Xpos;
    this.myOldYPos = Ypos;
    this.myOldAngle = turtleAngle;
    this.myPen = pen;
    this.myID = turtleID;
    CANVAS_DIMENSIONS = Integer.parseInt(myResources.getString("CanvasDimensions"));


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
    myAngle = angle % 360;
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
   * Changes the coordinates of the turtle to new X and Y locations
   * @param newXPos : new X coordinate to be set
   * @param newYPos : new Ycoordinate to be set
   * @throws ModelExceptions: the exception to be thrown for when the turtle is moved to a position out of bounds
   */
  public void changeTurtleLocation(double newXPos, double newYPos) throws ModelExceptions {
    if(Math.abs(newXPos) > CANVAS_DIMENSIONS || Math.abs(newYPos) > CANVAS_DIMENSIONS){
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

  /**
   * Turtle ID is the unique number assigned to every turtle made. This method gets the Turtle's ID
   * @return turtle's ID as an integer.
   */
  public int getTurtleID(){
    return myID;
  }

}
