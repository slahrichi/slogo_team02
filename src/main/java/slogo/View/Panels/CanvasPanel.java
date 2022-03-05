package slogo.View.Panels;

import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;

public class CanvasPanel {

  private StackPane canvasPane;
  private TurtleView turtleView;
  private CanvasView canvasView;
  private Stage myStage;
  private ResourceBundle canvasResources;
  private ResourceBundle turtleResources;

  private static final String CANVAS_RESOURCE_PACKAGE = "/view/Canvas";
  private static final String TURTLE_RESOURCE_PACKAGE = "/view/Turtle";


  public CanvasPanel(Stage stageInput){

    canvasResources = ResourceBundle.getBundle(CANVAS_RESOURCE_PACKAGE);
    turtleResources = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

    myStage = stageInput;
    canvasPane = new StackPane();
    setUpCanvasPanel();

    canvasView = new CanvasView(canvasPane, canvasResources);
    turtleView = new TurtleView(canvasPane, turtleResources);

  }

  private void setUpCanvasPanel(){

    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(
        Double.parseDouble(canvasResources.getString("WidthProperty"))));


  }

  public StackPane getCanvasPanel(){
    return canvasPane;
  }

  public TurtleView getTurtleView(){ return turtleView;}

  public CanvasView getCanvasView(){ return canvasView;}



}
