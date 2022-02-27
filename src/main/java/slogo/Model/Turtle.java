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
  public static final Dimension BOUNDS= Main.DEFAULT_SIZE;

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

}
