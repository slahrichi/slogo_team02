package slogo.View.Objects;


import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Model.Turtle;

// should create the turtle image and handle its movement along with pen down
public class TurtleView {
  public final static double turtleSize = 50;
  public final static double CANVAS_OFFSET = turtleSize / 2;

  private StackPane canvasBox;
  private ImageView turtleImage;

  private double oldX;
  private double oldY;
  private double oldAngle;


  public TurtleView(StackPane outerPane){

    canvasBox = outerPane;
    turtleImage = new ImageView();
    setUpImage();
    canvasBox.getChildren().addAll(turtleImage);



    oldX = (turtleImage.getLayoutBounds().getWidth() / 2) - turtleImage.getLayoutX();
    oldY = (turtleImage.getLayoutBounds().getHeight() / 2) - turtleImage.getLayoutY();


  }

  private void setUpImage(){

    turtleImage.setImage(
        new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(turtleSize);
    turtleImage.setFitWidth(turtleSize);
  }

/*  public PathTransition updatePosition(Turtle turtleInput){

    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(oldX, oldY),
        new LineTo(0 + turtleSize, 0 + turtleSize));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(
        Duration.seconds(3),
        path, turtleImage);

    oldX = 50;
    oldY = 100;

    return pt;

  }*/

  public void updatePosition(Turtle turtleInput){
    turtleImage.setX(turtleInput.getTurtleX() + turtleSize);
    turtleImage.setY(turtleInput.getTurtleY() + turtleSize);

  }

  public void updateAngle(Turtle turtleInput){


  }

  // back end should send something like a turtle info / record object rather than sending the turtle itself
  // as a barrier from the view being able to edit the turtle




}
