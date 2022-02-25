package slogo.View;

import java.awt.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class CanvasView {

  private StackPane canvasBox;
  private Canvas turtleCanvas;

  public CanvasView(StackPane outerPane) {

    canvasBox = outerPane;
    turtleCanvas = new Canvas(800, 800);
    GraphicsContext gc = turtleCanvas.getGraphicsContext2D();
    setupCanvas(gc);
    canvasBox.getChildren().addAll(turtleCanvas);

  }

  private void setupCanvas(GraphicsContext gc){
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, 800, 800);

  }


}
