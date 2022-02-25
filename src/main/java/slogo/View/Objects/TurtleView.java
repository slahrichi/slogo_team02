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

  public PathTransition updatePosition(){

    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(oldX, oldY),
        new LineTo(0, 0 ));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(
        Duration.seconds(3),
        path, turtleImage);

    oldX = 50;
    oldY = 100;

    return pt;

  }

}
