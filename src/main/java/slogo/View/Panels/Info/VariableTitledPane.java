package slogo.View.Panels.Info;

// one of the subclasses of side titled pane

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VariableTitledPane extends SideTitledPane {

  private static final int PANE_PADDING = 10;
  private static final int PANE_GAP = PANE_PADDING / 2;

  private VBox sidePanel;
  private TitledPane variablePane;
  private GridPane variableGrid;

  public VariableTitledPane(VBox sideInput) {
    super(sideInput);

    variablePane = new TitledPane();
    variableGrid = new GridPane();

    sidePanel = sideInput;
    setUpVariableGrid();
    setUpVariablePane();

    variableGrid = new GridPane();
    variableGrid.setPadding(new Insets(10));
    variableGrid.setHgap(5);
    variableGrid.setVgap(5);
    variableGrid.add(new Label("Variable 1 Here and Stats"), 0, 1);
    variableGrid.add(new Label("Variable 2 Here and Stats"), 0, 2);

  }


  private void setUpVariablePane(){

    variablePane.setExpanded(false);
    variablePane.setText("Variables");
    variablePane.setId("variablePane");
    variablePane.setContent(variableGrid);

  }

  private void setUpVariableGrid(){
    variableGrid.setPadding(new Insets(PANE_PADDING));
    variableGrid.setHgap(PANE_GAP);
    variableGrid.setVgap(PANE_GAP);
    variableGrid.add(new Label("Variable 1 Here and Stats"), 0, 1);
    variableGrid.add(new Label("Variable 2 Here and Stats"), 0, 2);
  }

  public TitledPane getVariablePane(){
    return variablePane;
  }

  @Override
  public void addPane() {

  }


  @Override
  public void addVariable(int variable) {

  }


}
