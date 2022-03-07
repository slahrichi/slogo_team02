package slogo.View.Panels;

import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;

/**
 * Purpose: The CanvasPanel holds the middle of the BorderPane, which is where the Canvas and Turtle
 * image are made and held.
 * <p>
 * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and passed
 * the correct Stage object which it can use to correctly size itself.
 * <p>
 * Dependencies: Depends on the main slogoGUI class where it's created, ResourceBundle, and
 * different Javafx imports in order to function
 * <p>
 * Example: Created in the slogoGUI class and encapsulates the Canvas and Turtle which the users
 * control using commands
 *
 * @author Eric Xie
 *
 **/

public class CanvasPanel {

  private StackPane canvasPane;
  private TurtleView turtleView;
  private CanvasView canvasView;
  private Stage myStage;
  private ResourceBundle canvasResources;
  private ResourceBundle turtleResources;

  private static final String CANVAS_RESOURCE_PACKAGE = "/view/Canvas";
  private static final String TURTLE_RESOURCE_PACKAGE = "/view/Turtle";

  /**
   * Purpose: The CanvasPanel object constructor, which sets up the basic things for the CanvasView and
   * TurtleView objects
   * <p>
   * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and
   * passed the correct Stage object which it can use to correctly size itself.
   *
   * @param stageInput the stage that holds all the elements in the GUI
   **/


  public CanvasPanel(Stage stageInput) {

    canvasResources = ResourceBundle.getBundle(CANVAS_RESOURCE_PACKAGE);
    turtleResources = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

    myStage = stageInput;
    canvasPane = new StackPane();
    setUpCanvasPanel();

    canvasView = new CanvasView(canvasPane, canvasResources);
    turtleView = new TurtleView(canvasPane, turtleResources);

  }

  // sets up the canvas panel and width property

  private void setUpCanvasPanel() {

    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(
        Double.parseDouble(canvasResources.getString("WidthProperty"))));


  }

  /**
   * Purpose: Retrieves the Canvas pane in the class
   * <p>
   * Assumption: Called whenever necessary to retrieve the canvasPane and returns the correct pane
   *
   * @return canvasPane, a Stack Pane that holds the Canvas and Turtle/ImageView object
   **/


  public StackPane getCanvasPanel() {
    return canvasPane;
  }

  /**
   * Purpose: Retrieves the TurtleView class in the stack pane
   * <p>
   * Assumption: Called whenever necessary to retrieve the TurtleView class and returns the correct
   * one
   *
   * @return turtleView, the class that encapsulates the ImageView of the turtle
   **/

  public TurtleView getTurtleView() {
    return turtleView;
  }

  /**
   * Purpose: Retrieves the CanvasView class in the stack pane
   * <p>
   * Assumption: Called whenever necessary to retrieve the CanvasView class and returns the correct
   * one
   *
   * @return turtleView, the class that encapsulates the Canvas on which the user draws
   **/

  public CanvasView getCanvasView() {
    return canvasView;
  }


}
