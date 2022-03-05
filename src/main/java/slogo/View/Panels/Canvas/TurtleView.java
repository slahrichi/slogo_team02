package slogo.View.Panels.Canvas;


import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


/**
 * Purpose: Create and set up the Turtle Image on the StackPane with the canvas
 * <p>
 * Assumption: We assume that the TurtleView is correctly passed the right inputs and intialized in the correct place
 * in the right order on the stackpane.
 * <p>
 * Dependencies: This class depends on StackPane and various javafx image imports as well as the Canvas Panels class
 * <p>
 * Example: Used in the CanvasPanel class to create a TurtleImage (ImageView) object and set it up on the StackPane
 * <p>
 *
 *
 * @author Eric Xie
 *
 */


public class TurtleView {

  public static double TURTLE_SIZE;
  public static double TURTLE_OFFSET;
  private static double LINE_OFFSET;

  private StackPane canvasBox;
  private ImageView turtleImage;

  private ResourceBundle myResources;

  /**
   * Purpose: Constructor for the TurtleView class that takes in the inputs and sets them to its respective
   * instance variables; also sets up the ImageView for the turtle on the canvas
   * <p>
   * Assumption: We assume that the TurtleView is correctly passed the right inputs and intialized in the correct place
   * in the right order on the stack pane.
   * <p>
   * Example: Used in the CanvasPanel class to create a TurtleImage (ImageView) object and set it up on the StackPane
   * <p>
   *
   * @oaram canvasInput StackPane that we put the turtle image on
   * @param resources The ResourceBundle that we get the image we want off on
   *
   *
   */

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
