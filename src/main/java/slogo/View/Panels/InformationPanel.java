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


/**
 * Purpose: The InformationPane holds the right side elements of the BorderPane, which is where the
 * Titled information panes are made and held
 * <p>
 * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and passed
 * the correct Stage object which it can use to correctly size itself.
 * <p>
 * Dependencies: Depends on the main slogoGUI class where it's created, the AnimationHandler class,
 * and different Javafx imports in order to function
 * <p>
 * Example: Created in the slogoGUI class and encapsulates the multiple informational panes that
 * hold the users' tools and commands/variables
 *
 * @author Eric Xie
 **/


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

  /**
   * Purpose: The InformationPane object constructor, which sets up the basic things for how its
   * displayed and constructs the different kinds of information panes
   * <p>
   * Assumptions: I assume that this is correctly created and set up in the slogoGUI class and
   * passed the correct Stage object which it can use to correctly size itself.
   *
   * @param stageInput the stage that holds all the elements in the GUI
   * @param anim       AnimationHandler class object that is used to move the turtle
   * @param canvasView CanvasView class object that holds the canvas where the user draws on
   **/


  public InformationPanel(Stage stageInput, AnimationHandler anim, CanvasView canvasView) {

    canvasInput = canvasView;
    animationHandler = anim;
    myStage = stageInput;
    infoBox = new VBox();
    setUpPanels();

  }

  // sets up all the different information panels


  private void setUpPanels() {

    infoBox.setId("infoPanel");

    variablePane = new VariableTitledPane(infoBox);
    historyPane = new CommandHistoryPane(infoBox);
    colorPane = new BackgroundColorPane(infoBox, canvasInput);
    penPane = new PenColorPane(infoBox, animationHandler);
    helpPane = new HelpPane(infoBox);
    infoBox.prefWidthProperty().bind(myStage.widthProperty().multiply(STAGE_WIDTH_PROPORTION));

  }

  /**
   * Purpose: Retrieves the VBox where the InformationPanel is created
   * <p>
   * Assumption: Called whenever necessary to retrieve the VBox and returns the correct one
   *
   * @return infoBox, the VBox that holds the InformationPanel
   **/

  public VBox getInfoBox() {
    return infoBox;
  }

  /**
   * Purpose: Retrieves the command history Text object from the history pane
   * <p>
   * Assumption: Called whenever necessary to retrieve the command history Text object and returns
   * the correct object
   *
   * @return the Text object of the history pane
   **/

  public Text getHistoryText() {
    return historyPane.getText();
  }

  /**
   * Purpose: Retrieves the SideTitledPane historyPane that's created in this class
   * <p>
   * Assumption: Called whenever necessary to retrieve the pane itself and returns the correct one
   *
   * @return historyPane, the SideTitledPane containing the command history
   **/

  public SideTitledPane getHistoryPane() {
    return historyPane;
  }

  /**
   * Purpose: Retrieves the SideTitledPane variablePane that's created in this class
   * <p>
   * Assumption: Called whenever necessary to retrieve the pane itself and returns the correct one
   *
   * @return variablePane, the SideTitledPane containing the user variables
   **/

  public SideTitledPane getVariablePane() {
    return variablePane;
  }

  /**
   * Purpose: Retrieves the SideTitledPane colorPane that's created in this class
   * <p>
   * Assumption: Called whenever necessary to retrieve the pane itself and returns the correct one
   *
   * @return colorPane, the SideTitledPane containing the background color changing options
   **/

  public SideTitledPane getColorPane() {
    return colorPane;
  }

  /**
   * Purpose: Retrieves the SideTitledPane penPane that's created in this class
   * <p>
   * Assumption: Called whenever necessary to retrieve the pane itself and returns the correct one
   *
   * @return penPane, the SideTitledPane containing the pen color changing options
   **/

  public SideTitledPane getPenPane() {
    return penPane;
  }

  /**
   * Purpose: Retrieves the SideTitledPane helpPane that's created in this class
   * <p>
   * Assumption: Called whenever necessary to retrieve the pane itself and returns the correct one
   *
   * @return helpPane, the SideTitledPane containing helpful information
   **/

  public SideTitledPane getHelpPane() {
    return helpPane;
  }


}
