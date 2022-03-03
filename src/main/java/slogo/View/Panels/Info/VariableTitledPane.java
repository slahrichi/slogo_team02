package slogo.View.Panels.Info;

// one of the subclasses of side titled pane

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VariableTitledPane extends SideTitledPane {


  public VariableTitledPane(VBox sideInput) {
    super(sideInput);

    setUpVariableGrid();
    setUpVariablePane();


  }


  private void setUpVariablePane(){

    getPane().setText("Variables");
    getPane().setId("variablePane");


  }

  private void setUpVariableGrid(){
    getGridPane().add(new Label("Variable 1 Here and Stats"), 0, 1);
    getGridPane().add(new Label("Variable 2 Here and Stats"), 0, 2);
  }



  @Override
  protected void addPane() {

  }


  @Override
  protected void addVariable(int variable) {

  }




}
