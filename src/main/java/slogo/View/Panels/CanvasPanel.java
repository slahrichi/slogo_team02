package slogo.View.Panels;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;

public class CanvasPanel {

  private StackPane canvasPane;
  private TurtleView turtleView;
  private CanvasView canvasView;
  private Stage myStage;

  private static final double WIDTH_PROPORTION = 0.6;

  public CanvasPanel(Stage stageInput){

    myStage = stageInput;

    canvasPane = new StackPane();
    setUpCanvasPanel();

    canvasView = new CanvasView(canvasPane);
    turtleView = new TurtleView(canvasPane);

  }

  private void setUpCanvasPanel(){

    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(WIDTH_PROPORTION));


  }

  public StackPane getCanvasPanel(){
    return canvasPane;
  }

  public TurtleView getTurtleView(){ return turtleView;}

  public CanvasView getCanvasView(){ return canvasView;}


}
