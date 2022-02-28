package slogo.View.Panels.Canvas;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import slogo.View.AnimationHandler;


// should create the turtle image and handle its movement along with pen down
public class TurtleView {
  public final static double TURTLE_SIZE = 50;
  public final static double TURTLE_OFFSET = TURTLE_SIZE / 2;

  private AnimationHandler anim;
  private StackPane canvasBox;
  private ImageView turtleImage;




  public TurtleView(StackPane canvasInput){

    turtleImage = new ImageView();
    canvasBox = canvasInput;
    setUpImage();


//    oldX = (turtleImage.getLayoutBounds().getWidth() / 2) - turtleImage.getLayoutX();
//    oldY = (turtleImage.getLayoutBounds().getHeight() / 2) - turtleImage.getLayoutY();
//    System.out.println(oldX + " " + oldY);

  }

  private void setUpImage(){

    turtleImage.setImage(
        new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(TURTLE_SIZE);
    turtleImage.setFitWidth(TURTLE_SIZE);
    canvasBox.getChildren().addAll(turtleImage);

  }



  public ImageView getTurtleImage(){
    return turtleImage;
  }



  // back end should send something like a turtle info / record object rather than sending the turtle itself
  // as a barrier from the view being able to edit the turtle




}