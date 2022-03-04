package slogo.View.Panels.Canvas;

import java.awt.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class CanvasView {

  private StackPane canvasBox;
  private Canvas turtleCanvas;
  private GraphicsContext gc;

  private static final int CANVAS_DIMENSIONS = 800;

  public CanvasView(StackPane outerPane) {

    canvasBox = outerPane;
    turtleCanvas = new Canvas(CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);
    gc = turtleCanvas.getGraphicsContext2D();
    setupCanvas(gc);
    canvasBox.getChildren().addAll(turtleCanvas);

  }

  private void setupCanvas(GraphicsContext gc){
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);

  }

  public Canvas getTurtleCanvas(){
    return turtleCanvas;
  }

  public GraphicsContext getContext(){
    return gc;
  }

  public void clearCanvas(){
    gc.clearRect(0, 0, getTurtleCanvas().getHeight(), getTurtleCanvas().getWidth());
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);
  }


}
