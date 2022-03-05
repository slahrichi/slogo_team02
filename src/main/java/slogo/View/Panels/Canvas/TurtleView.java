package slogo.View.Panels.Canvas;


import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import slogo.View.AnimationHandler;


// should create the turtle image and handle its movement along with pen down
public class TurtleView {

  public static double TURTLE_SIZE;
  public static double TURTLE_OFFSET;
  private static double LINE_OFFSET;

  private StackPane canvasBox;
  private ImageView turtleImage;

  private ResourceBundle myResources;


  public TurtleView(StackPane canvasInput, ResourceBundle resources){

    myResources = resources;

    TURTLE_SIZE = Double.parseDouble(myResources.getString("TurtleSize"));
    TURTLE_OFFSET = Double.parseDouble(myResources.getString("TurtleOffset"));
    LINE_OFFSET = Double.parseDouble(myResources.getString("LineOffset"));

    turtleImage = new ImageView();
    canvasBox = canvasInput;
    setUpImage();

  }

  private void setUpImage(){

    turtleImage.setImage(
        new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(TURTLE_SIZE);
    turtleImage.setFitWidth(TURTLE_SIZE);
    turtleImage.setX(LINE_OFFSET);
    turtleImage.setY(LINE_OFFSET);
    canvasBox.getChildren().addAll(turtleImage);
    turtleImage.setId("TurtleImage");
  }



  public ImageView getTurtleImage(){
    return turtleImage;
  }



  // back end should send something like a turtle info / record object rather than sending the turtle itself
  // as a barrier from the view being able to edit the turtle




}
