package slogo.Model;
import java.awt.Dimension;
import java.util.List;
import slogo.Main;
import slogo.Model.Commands.Command;

/**
 * @author Haris Adnan
 */
public class Turtle {

  private String DEFAULT_IMAGE;
  private int TURTLE_SIZE;
  //public double STARTING_TURTLE_ANGLE;

  private double myXPos;
  private double myYPos;
  private double myAngle;
  private Pen myPen;
  List<Command> myCommandList;
  private Canvas theCanvas;

  // Change this to the Bounds of the screen
  public static final Dimension BOUNDS= Main.DEFAULT_SIZE;

  // Initiliaze Centre of Screen Coordinates
  public static Point CENTER_OF_SCREEN ;


//Remove Command list

  public Turtle(double Xpos, double Ypos, double turtleAngle, Pen pen){
    this.myXPos = Xpos;
    this.myYPos = Ypos;
    this.myAngle = turtleAngle;
    this.myPen = pen;
  }
  public double getAngle() {
    return myAngle;
  }
  public void setAngle(double angle){
    myAngle = angle;
  }

  public double getTurtleX(){
    return myXPos;
  }
  public double getTurtleY(){
    return myYPos;
  }

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
  public void changeTurtleLocation(double newXPos, double newYPos) throws ModelExceptions {
    if(newXPos > BOUNDS.width || newYPos > BOUNDS.width){
      throw new ModelExceptions("Error with bounds");
    }
    myXPos = newXPos;
    myYPos = newYPos;
  }
  public boolean isPenDown() {
    return myPen.isMyPenDown();
  }
  public void setPenDown(){
    myPen.setPenDown(true);
  }
  public void setPenUp(){
    myPen.setPenDown(false);
  }
  //is turtle showing method need to be implemented in GUI
  public boolean isTurtleShowing(){
    return true;
  }

}
