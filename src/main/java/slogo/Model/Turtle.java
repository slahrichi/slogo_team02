package slogo.Model;

/**
 * @author Haris Adnan
 */
public class Turtle {

  private String DEFAULT_IMAGE;
  private int TURTLE_SIZE;
  public double STARTING_TURTLE_ANGLE;



  private double myXPos;
  private double myYPos;
  private double myAngle;
  private Pen myPen;
  List<Command> myCommandList;

  public Turtle(double Xpos, double Ypos, List<Command> CommandList{
    turtleImage = new javafx.scene.image.Image(this.getClass().getResourceAsStream(DEFAULT_IMAGE));
    this.myXPos = Xpos;
    this.myYPos = Ypos;
    this.myCommandList = CommandList;
  }
  public double getAngle() {
    return 1.0;
  }
  public void setAngle(int angle){
  }
  public double getTurtleX(){
    return 1.0;
  }
  public double getTurtleY(){
    return 1.0;
  }
  public void turn(double angle){
    myAngle += angle;
  }
  public void moveTurtle(Command givenComamnd){
    // do command
  }





}
