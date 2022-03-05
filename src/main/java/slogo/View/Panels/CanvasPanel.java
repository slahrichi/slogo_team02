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
  private ResourceBundle myResources;

  private static final String DEFAULT_RESOURCE_PACKAGE = "/view/Canvas";

  public CanvasPanel(Stage stageInput){

    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);

    myStage = stageInput;
    canvasPane = new StackPane();
    setUpCanvasPanel();

    canvasView = new CanvasView(canvasPane, myResources);
    turtleView = new TurtleView(canvasPane);

  }

  private void setUpCanvasPanel(){

    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(
        Double.parseDouble(myResources.getString("WidthProperty"))));


  }

  public StackPane getCanvasPanel(){
    return canvasPane;
  }

  public TurtleView getTurtleView(){ return turtleView;}

  public CanvasView getCanvasView(){ return canvasView;}



}
