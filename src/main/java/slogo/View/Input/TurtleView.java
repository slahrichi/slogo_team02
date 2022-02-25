package slogo.View.Input;


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

  private StackPane canvasBox;
  private ImageView turtleImage;

  private double oldX;
  private double oldY;


  public TurtleView(StackPane outerPane){

    canvasBox = outerPane;
    turtleImage = new ImageView();
    setUpImage();
    canvasBox.getChildren().addAll(turtleImage);

    oldX = turtleImage.getLayoutX();
    oldY = turtleImage.getLayoutY();


  }

  private void setUpImage(){

    turtleImage.setImage(
        new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(75);
    turtleImage.setFitWidth(75);
  }

  public PathTransition updatePosition(){

    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(oldX, oldY),
        new LineTo(50, 100));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(
        Duration.seconds(3),
        path, turtleImage);

    oldX = 50;
    oldY = 100;

    return pt;

  }

}
