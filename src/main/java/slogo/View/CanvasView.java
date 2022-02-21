package slogo.View;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class CanvasView {

  private StackPane canvasBox;
  private Canvas turtleCanvas;
  private ImageView turtleImage;

  public CanvasView(StackPane outerPane){

    canvasBox = outerPane;
    turtleCanvas = new Canvas(800, 800);
    GraphicsContext gc = turtleCanvas.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, 800, 800);
    turtleImage = new ImageView();
    turtleImage.setImage(new Image(getClass().getResource("/turtlePictures/turtleImage.png").toString(), true));
    turtleImage.setFitHeight(75);
    turtleImage.setFitWidth(75);
    canvasBox.getChildren().addAll(turtleCanvas, turtleImage);

  }


}
