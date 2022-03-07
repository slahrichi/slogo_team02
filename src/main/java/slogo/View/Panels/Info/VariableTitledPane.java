package slogo.View.Panels.Info;

// one of the subclasses of side titled pane

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Purpose: The purpose of this class is to hold the SideTitledPane subclass VariableTitledPane,
 * which essentially manages the TitledPane that holds user created variables
 * <p>
 * Assumptions: I assume that this class is created correctly in the InformationalPanel, which holds
 * all the other titledpanes that have things to do with giving the user information
 * <p>
 * Dependencies: This class has dependencies on the InformationalPane class where its created and
 * imports multiple JavaFx Scene dependencies.
 * <p>
 * Example: This is used in the InformationPane class when creating every information pane on the
 * right side of the program. It *should* display variables that were created by the user inside.
 *
 * @author Eric Xie
 */

public class VariableTitledPane extends SideTitledPane {

  /**
   * Purpose: The constructor for VariableTitledPane objects
   * <p>
   * Assumptions: I assume that this class is created correctly in the InformationalPanel, which
   * holds all the other titledpanes that have things to do with giving the user information
   *
   * @param sideInput the VBox that the pane is added into
   **/

  public VariableTitledPane(VBox sideInput) {
    super(sideInput);

    setUpVariableGrid();
    setUpVariablePane();


  }

  // sets up the variable pane

  private void setUpVariablePane() {

    getPane().setText("Variables");
    getPane().setId("variablePane");


  }

  // sets up the grid inside the pane

  private void setUpVariableGrid() {
    getGridPane().add(new Label("Variable 1 Here and Stats"), 0, 1);
    getGridPane().add(new Label("Variable 2 Here and Stats"), 0, 2);
  }

  // should have been integrated with the controller to take in variables that the user created

  private void addVariable() {

  }


}
