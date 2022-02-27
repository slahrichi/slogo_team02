package slogo.View;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import slogo.View.Panels.Objects.CanvasView;
import slogo.View.Panels.Objects.TurtleView;

public class CanvasPanel {

  StackPane canvasPane;
  TurtleView turtleView;
  CanvasView canvasView;
  Stage myStage;

  public CanvasPanel(Stage stageInput){

    myStage = stageInput;

    canvasPane = new StackPane();
    setUpCanvasPanel();

    canvasView = new CanvasView(canvasPane);
    turtleView = new TurtleView(canvasPane);

  }

  private void setUpCanvasPanel(){

    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(0.6));


  }

  public StackPane getCanvasPanel(){
    return canvasPane;
  }



}
