package slogo.View.Panels.Canvas;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


// should create the turtle image and handle its movement along with pen down
public class TurtleView {
  public final static double turtleSize = 50;

  private StackPane canvasBox;
  private ImageView turtleImage;

  private double oldX;
  private double oldY;
  private double oldAngle;


  public TurtleView(StackPane outerPane){

    canvasBox = outerPane;
    turtleImage = new ImageView();
    setUpImage();

    oldX = (turtleImage.getLayoutBounds().getWidth() / 2) - turtleImage.getLayoutX();
    oldY = (turtleImage.getLayoutBounds().getHeight() / 2) - turtleImage.getLayoutY();
    System.out.println(oldX + " " + oldY);

  }

  private void setUpImage(){

    turtleImage.setImage(
        new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(turtleSize);
    turtleImage.setFitWidth(turtleSize);
    canvasBox.getChildren().addAll(turtleImage);

  }

  public void setOldX(double input){
    oldX = input;
  }

  public void setOldY(double input){
    oldY = input;
  }

  public void setAngle(double input){
    oldAngle = input;
  }

  public double getOldX(){
    return oldX;
  }

  public double getOldY(){
    return oldY;
  }

  public double getAngle(){
    return oldAngle;
  }

  public ImageView getTurtleImage(){
    return turtleImage;
  }



  // back end should send something like a turtle info / record object rather than sending the turtle itself
  // as a barrier from the view being able to edit the turtle




}
