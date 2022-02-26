package slogo.View.Panels;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.View.Panels.Info.VariableTitledPane;

public class InformationPanel {

  private static final double STAGE_WIDTH_PROPORTION = 0.2;

  private Stage myStage;
  private VBox infoBox;
  private VariableTitledPane variablePane;


  public InformationPanel(Stage stageInput){

    myStage = stageInput;
    infoBox = new VBox();
    setUpPanel();

  }

  private void setUpPanel(){

    variablePane = new VariableTitledPane(infoBox);
    infoBox.setId("infoPanel");

    infoBox.getChildren().add(variablePane.getVariablePane());
    infoBox.prefWidthProperty().bind(myStage.widthProperty().multiply(STAGE_WIDTH_PROPORTION));

  }

  public VBox getInfoBox(){
    return infoBox;
  }

}
