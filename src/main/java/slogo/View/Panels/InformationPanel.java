package slogo.View.Panels;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import slogo.View.AnimationHandler;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Info.BackgroundColorPane;
import slogo.View.Panels.Info.CommandHistoryPane;
import slogo.View.Panels.Info.HelpPane;
import slogo.View.Panels.Info.PenColorPane;
import slogo.View.Panels.Info.SideTitledPane;
import slogo.View.Panels.Info.VariableTitledPane;

public class InformationPanel {

  private static final double STAGE_WIDTH_PROPORTION = 0.2;

  private Stage myStage;
  private VBox infoBox;
  private VariableTitledPane variablePane;
  private BackgroundColorPane colorPane;
  private CommandHistoryPane historyPane;
  private PenColorPane penPane;
  private HelpPane helpPane;
  private CanvasView canvasInput;
  private AnimationHandler animationHandler;


  public InformationPanel(Stage stageInput, AnimationHandler anim, CanvasView canvasView){

    canvasInput = canvasView;
    animationHandler = anim;
    myStage = stageInput;
    infoBox = new VBox();
    setUpPanels();

  }

  private void setUpPanels(){

    infoBox.setId("infoPanel");

    variablePane = new VariableTitledPane(infoBox);
    historyPane = new CommandHistoryPane(infoBox);
    colorPane = new BackgroundColorPane(infoBox, canvasInput);
    penPane = new PenColorPane(infoBox, animationHandler);
    helpPane = new HelpPane(infoBox);
    infoBox.prefWidthProperty().bind(myStage.widthProperty().multiply(STAGE_WIDTH_PROPORTION));

  }

  public VBox getInfoBox(){
    return infoBox;
  }

  public Text getHistoryText() { return historyPane.getText();}

  public SideTitledPane getHistoryPane(){return historyPane;}

  public SideTitledPane getVariablePane(){return variablePane;}

  public SideTitledPane getColorPane(){return colorPane;}

  public SideTitledPane getPenPane(){ return penPane;}

  public SideTitledPane getHelpPane() { return helpPane;}


}
