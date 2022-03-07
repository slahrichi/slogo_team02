package slogo.View.Panels;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.View.Panels.Input.EditorView;
import slogo.View.Panels.Input.ShellView;

/**
 * Purpose: The InputPanel holds the left elements of the BorderPane, which is where the Shell and
 * File Editor are made and held.
 * <p>
 * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and passed
 * the correct Stage object which it can use to correctly size itself.
 * <p>
 * Dependencies: Depends on the main slogoGUI class where it's created, Stage, and different Javafx
 * imports in order to function
 * <p>
 * Example: Created in the slogoGUI class and encapsulates the File Editor and Shell text area which
 * the users can utilize to move the turtles
 *
 * @author Eric Xie
 **/

public class InputPanel {

  private VBox sidePanel;
  private Stage myStage;
  private ShellView shellView;
  private EditorView editorView;

  private static final double INPUT_PROPORTION = 0.2;

  /**
   * Purpose: The InputPanel object constructor, which sets up the basic things and constructs the
   * side panel elements of shell and file editor
   * <p>
   * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and
   * passed the correct Stage object which it can use to correctly size itself.
   *
   * @param stageInput the stage that holds all the elements in the GUI
   **/

  public InputPanel(Stage stageInput) {

    myStage = stageInput;
    sidePanel = new VBox();
    sidePanel.setId("inputPanel");
    setUpPanel();

  }

  // sets up the panel itself and constructs the elements inside of it

  private void setUpPanel() {
    shellView = new ShellView(sidePanel);
    editorView = new EditorView(sidePanel);
    sidePanel.prefWidthProperty().bind(myStage.widthProperty().multiply(INPUT_PROPORTION));
  }

  /**
   * Purpose: Retrieves the Vbox that's created in the InputPanel
   * <p>
   * Assumption: Called whenever necessary to retrieve the Vbox and returns the correct one
   *
   * @return sidePanel, the VBox that the InputPanel creates and is where the elements are put on
   **/

  public VBox getSidePanel() {
    return sidePanel;
  }

  /**
   * Purpose: Retrieves the ShellView class object that's created in the InputPanel
   * <p>
   * Assumption: Called whenever necessary to retrieve the object and returns the correct one
   *
   * @return shelLView, the class object created that contains the shell input for users to use
   **/

  public ShellView getShellView() {
    return shellView;
  }

  /**
   * Purpose: Retrieves the EditorView class object that's created in the InputPanel
   * <p>
   * Assumption: Called whenever necessary to retrieve the object and returns the correct one
   *
   * @return editorView, the class object created that contains the editor input for users to use
   **/

  public EditorView getEditorView() {
    return editorView;
  }
}
