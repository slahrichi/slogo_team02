package slogo.View.Panels;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import slogo.Control.ControllerAPI;
import slogo.View.Panels.Info.BackgroundColorPane;
import slogo.View.Panels.Info.CommandHistoryPane;
import slogo.View.Panels.Info.VariableTitledPane;

public class InformationPanel {

  private static final double STAGE_WIDTH_PROPORTION = 0.2;

  private Stage myStage;
  private VBox infoBox;
  private VariableTitledPane variablePane;
  private BackgroundColorPane colorPane;
  private CommandHistoryPane historyPane;
  private ControllerAPI control;


  public InformationPanel(Stage stageInput, ControllerAPI controlInput){

    myStage = stageInput;
    infoBox = new VBox();
    setUpPanels();
    control = controlInput;

  }

  private void setUpPanels(){

    infoBox.setId("infoPanel");

    variablePane = new VariableTitledPane(infoBox);
    historyPane = new CommandHistoryPane(infoBox, control);
    colorPane = new BackgroundColorPane(infoBox);

    infoBox.prefWidthProperty().bind(myStage.widthProperty().multiply(STAGE_WIDTH_PROPORTION));

  }

  public VBox getInfoBox(){
    return infoBox;
  }

  public Text getHistoryText() { return historyPane.getText();}

}
