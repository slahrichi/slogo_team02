package slogo.View.Panels.Canvas;

import java.util.ResourceBundle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import slogo.View.Observer.ViewListener;

/**
 * Purpose: Creates the Canvas object and sets up its Graphical Context to be shown on screen for
 * drawing the users inputs on
 * <p>
 * Assumption: Assume that the stackpane and resourcebundle provided are the correct elements for
 * creating this canvas
 * <p>
 * Dependencies: This class depends on Canvas and various javafx scene imports as well as the Canvas
 * Panels class
 * <p>
 * Example: Used in the CanvasPanel class to create a Canvas object and set it up
 * <p>
 *
 * @author Eric Xie
 */


public class CanvasView implements ViewListener {

  private StackPane canvasBox;
  private Canvas turtleCanvas;
  private GraphicsContext gc;
  private ResourceBundle myResources;

  private final int CANVAS_DIMENSIONS;

  /**
   * Purpose: Creates the Canvas object and sets up its Graphical Context to be shown on screen for
   * drawing the users inputs on
   * <p>
   * Assumption: Assume that the stackpane and resourcebundle provided are the correct elements for
   * creating this canvas
   * <p>
   * Dependencies: This class depends on Canvas and various javafx scene imports as well as the
   * Canvas Panels class
   * <p>
   * Example: Used in the CanvasPanel class to create a Canvas object and set it up
   * <p>
   *
   * @param resources ResourceBundle to pull canvas things out of
   * @param: outerPane StackPane that you add the canvas onto
   * @author Eric Xie
   */

  public CanvasView(StackPane outerPane, ResourceBundle resources) {

    myResources = resources;
    canvasBox = outerPane;
    CANVAS_DIMENSIONS = Integer.parseInt(myResources.getString("CanvasDimensions"));
    turtleCanvas = new Canvas(CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);
    gc = turtleCanvas.getGraphicsContext2D();
    setupCanvas(gc);
    canvasBox.getChildren().addAll(turtleCanvas);


  }

  // set up the canvas in the constructor

  private void setupCanvas(GraphicsContext gc) {
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);

  }

  /**
   * Purpose: Retrieves the canvas itself for use in the slogoGUI
   * <p>
   * Assumptions: Assumed to be called whenever we need the canvas itself
   * <p>
   * Dependencies: Depends on the Canvas class where the CanvasView is instantiated in as well as
   * the graphics context
   * <p>
   *
   * @return turtleCanvas the canvas itself
   */

  public Canvas getTurtleCanvas() {
    return turtleCanvas;
  }

  /**
   * Purpose: Retrieves the graphical context of the turtle canvas
   * <p>
   * Assumptions: Assumed to be called whenever we need the graphical context
   * <p>
   * Dependencies: This context depends on the canvas in the canvasView it is called on
   * <p>
   * Example: Used in different classes to alter the color and things on the canvas in the animation
   * class
   * <p>
   *
   * @return gc graphical context to be retrieved
   */

  public GraphicsContext getContext() {
    return gc;
  }

  /**
   * Purpose: clears the canvas whenever the resetcanvas button is clicked
   * <p>
   * Assumption: assume that the canvas and its contents should be removed and the turtle should be
   * moved back to its original position once the button is clicked
   * <p>
   * Dependencies: Depends on the slogoGUI button that tells this to happen whenever it is clicked
   * <p>
   * Example: When resetCanvas button is clicked on the UI, should reset the canvas and turtle to
   * original position
   */

  public void clearCanvas() {
    gc.clearRect(0, 0, getTurtleCanvas().getHeight(), getTurtleCanvas().getWidth());
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);
  }

  /**
   * Purpose: Updates the canvas' color after being notified by the listener
   * <p>
   * Assumption: Assume that the color passed to it is the correct color that the user wants
   * <p>
   * Example: Used when the user picks a color on the ColorPicker in the backgroundColorPane
   * <p>
   *
   * @param colorInput Color that the canvas should become
   */
  @Override
  public void updateCanvas(Color colorInput) {
    gc.setFill(colorInput);
    gc.fillRect(0, 0, CANVAS_DIMENSIONS, CANVAS_DIMENSIONS);
  }

  // unused in this class
  @Override
  public void updatePen(Color colorInput) {

  }


}
