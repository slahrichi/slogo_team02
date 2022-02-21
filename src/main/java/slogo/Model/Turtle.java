package slogo.Model;
import java.awt.Dimension;
import java.util.List;
import javafx.scene.image.Image;
import slogo.Controller.Command;
import slogo.Main;

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
  public static final Dimension BOUNDS= Main.DEFAULT_SIZE;



  public Turtle(double Xpos, double Ypos, List<Command> CommandList, double turtleAngle){
    //Image turtleImage = new javafx.scene.image.Image(this.getClass().getResourceAsStream(DEFAULT_IMAGE));
    this.myXPos = Xpos;
    this.myYPos = Ypos;
    this.myAngle = turtleAngle;
    this.myCommandList = CommandList;
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
  public void turn(double angle){
    myAngle += angle;
  }
  public void moveTurtle(Command givenCommand){
    myPen.draw(givenCommand);
  }
  public void changeTurtleLocation(double newXPos, double newYPos){
    myXPos = newXPos;
    myYPos = newYPos;
    myAngle = 0.0;
  }






}
