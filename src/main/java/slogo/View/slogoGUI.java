package slogo.View;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import slogo.Control.CommandException;
import slogo.Control.Controller;
import slogo.Control.ControllerAPI;
import slogo.Main;
import slogo.Model.TurtleManagerException;
import slogo.View.APIs.ObserverViewInterface;
import slogo.View.APIs.ViewAPI;
import slogo.View.Configuration.SlogoReader;
import slogo.View.Configuration.SlogoWriter;
import slogo.View.Panels.CanvasPanel;
import slogo.View.Panels.InformationPanel;
import slogo.View.Panels.InputPanel;
import slogo.View.Panels.TitlePanel;

// class for creating the elements

/**
 * Purpose: The main class of the GUI that constructs the scene and implements the elements that are
 * displayed on said scene, including the BorderPane. Moreover, is the main class that interacts
 * with the Controller aspect of the project.
 * <p>
 * Assumptions: Correctly created and called in the Main and assumed that it's passed the correct
 * stage to be shown on; also assumed that a correct language that's in the resources is passed it
 * as well
 * <p>
 * Dependencies: Depends on Main as well as implements different APIs (ViewAPI,
 * ObserverViewInterface) and on the Controller class, which it communicates in order to display the
 * changes to the turtle, etc.
 * <p>
 * Example: After running Main, sets up the entire program and shows our Slogo UI
 *
 * @author Eric Xie
 */

public class slogoGUI implements ViewAPI, ObserverViewInterface {


  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String VIEW_RESOURCE_PACKAGE = "view/";
  private String STYLESHEET;

  public final FileChooser FILE_CHOOSER = createChooser("*.slogo");
  private ControllerAPI control;
  private TitlePanel titlePanel;
  private InputPanel inputPanel;
  private InformationPanel infoPanel;
  private CanvasPanel canvasPanel;
  private BorderPane myRoot;
  private ResourceBundle myResources;
  private Stage myStage;
  private AnimationHandler animationHandler;

  /**
   * Purpose: slogoGUI object constructor, which is used to set up the entire program itself and run
   * in the Main
   * <p>
   * Assumptions: Ran correctly in Main whenever we want to create a new SlogoGUI program
   *
   * @param stage,    the Stage object on which the application is shown on
   * @param language, the language of the program and commands being run
   */


  public slogoGUI(Stage stage, String language) {

    control = new Controller(this);

    //viewControlInstance = ViewController.getController();
    myStage = stage;
    myResources = ResourceBundle.getBundle(
        DEFAULT_RESOURCE_PACKAGE + VIEW_RESOURCE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(
        new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
    displayApp();
    animationHandler = new AnimationHandler(canvasPanel);
    displayInformation();

  }

  /**
   * Purpose: Creates the scene to be displayed on the stage after being passed the correct
   * BorderPane elements, width, and height
   * <p>
   * Assumptions: Used in the main correctly and displayed correctly onto the right stage
   *
   * @param width,  the preferred width of the scene
   * @param height, the preferred height of the scene
   * @return scene, the Scene object that is to be displayed on the Stage
   */

  public Scene makeScene(int width, int height) {

    Scene scene = new Scene(myRoot, width, height);
    scene.getStylesheets()
        .add(getClass().getResource(DEFAULT_RESOURCE_PACKAGE + STYLESHEET).toExternalForm());

    return scene;

  }

  // creates and displays all the application elements

  private void displayApp() {
    myRoot.setTop(makeTitle());
    myRoot.setLeft(createInputPanel());
    myRoot.setCenter(createTurtleCanvas());
    myRoot.setBottom(createConfigButtons());
  }

  // creates the information panel separately as it relies on other elements being created

  private void displayInformation() {
    myRoot.setRight(createInformationPanel());
  }

  // creates the title panel

  private HBox makeTitle() {

    titlePanel = new TitlePanel();
    return titlePanel.getTitleBox();

  }

  // creates the input panel

  private VBox createInputPanel() {

    inputPanel = new InputPanel(myStage);
    return inputPanel.getSidePanel();

  }

  /**
   * Purpose: Used to make Buttons
   * <p>
   * Assumptions: Passed the correct label name, event handler, and is in the resources; Called
   * whenever we want to make a new button
   *
   * @param labelName, name of the label to be found in the resources
   * @param handler,   the Event handler of the button
   * @param resources, the resources ResourceBundle
   * @return the button that is created
   */

  //create buttons with their own names and actions
  public static Button makeButton(String labelName, EventHandler<ActionEvent> handler,
      ResourceBundle resources) {

    Button buttonCreated = new Button();
    String buttonLabel = resources.getString(labelName);

    buttonCreated.setText(buttonLabel);
    buttonCreated.setOnAction(handler);
    buttonCreated.setId(labelName);

    return buttonCreated;

  }

  // creates the config buttons to be displayed at the bottom of the BorderPane

  private Node createConfigButtons() {

    HBox configBox = new HBox();
    configBox.setId("configButtonBox");
    Button playButton = makeButton("PlayButton",
        event -> {
          try {
            sendFileContents(inputPanel.getEditorView().getContents());
          } catch (Exception e) {
            showMessage(AlertType.ERROR, e.getMessage());
          }
        }, myResources);
    Button clearHistory = makeButton("ClearHistory", event -> clearHistory(), myResources);
    Button loadFile = makeButton("LoadFile", event -> loadFilePressed(), myResources);
    Button saveFile = makeButton("SaveFile", event -> saveFilePressed(), myResources);
    Button resetCanvas = makeButton("ResetCanvas", event -> resetCanvas(), myResources);
    Button resetSlogo = makeButton("resetSlogo", event -> Main.resetSlogo(myStage), myResources);
    Button addSlogo = makeButton("addSlogo", event -> Main.addSlogo(), myResources);

    configBox.getChildren()
        .addAll(playButton, clearHistory, loadFile, saveFile, resetCanvas, resetSlogo, addSlogo);
    return configBox;

  }

  // handles event when save button is pressed

  private void saveFilePressed() {
    SlogoWriter initial = new SlogoWriter(inputPanel.getEditorView().getContents(), myResources);
  }

  // handles event when load file button is pressed

  private void loadFilePressed() {

    try {
      File fileInput = FILE_CHOOSER.showOpenDialog(new Stage());
      if (fileInput != null) {
        SlogoReader initial = new SlogoReader(fileInput.getCanonicalPath());
        String fileContents = initial.getString();
        inputPanel.getEditorView().getTextArea().setText(fileContents);
      }
    } catch (IOException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }

  }

  // handles event when the reset canvas button is pressed

  private void resetCanvas() {
    canvasPanel.getCanvasView().clearCanvas();
    try {
      control.parseAndRunCommands("home");
    } catch (Exception e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
    infoPanel.getHistoryText().setText("");
    inputPanel.getEditorView().getTextArea().setText("");


  }

  // handles creating Canvas Panel


  private StackPane createTurtleCanvas() {

    canvasPanel = new CanvasPanel(myStage);

    return canvasPanel.getCanvasPanel();

  }

  // handles creating Information Panel

  private VBox createInformationPanel() {

    infoPanel = new InformationPanel(myStage, animationHandler, canvasPanel.getCanvasView());

    return infoPanel.getInfoBox();

  }

  // creates a File Chooser when we upload a file

  private FileChooser createChooser(String extension) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Data File");
    fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
    fileChooser.getExtensionFilters().setAll(
        new ExtensionFilter("Text Files", extension));

    return fileChooser;

  }

  /**
   * Purpose: When the run button is clicked, send the file contents of the file editor to the
   * controller
   * <p>
   * Assumptions: Correctly takes the file contents of the file editor and sends it to the
   * controller for parsing; correctly called when the run button is pressed
   *
   * @param fileContent the contents of the text area in the file editor
   * @throws Exception when parsing through the contents, if the commands are invalid, etc.
   */


  @Override
  public void sendFileContents(String fileContent)
      throws Exception {

    try {
      control.parseAndRunCommands(fileContent);

    } catch (CommandException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }


  }

  /**
   * Purpose: Notify the history for changes in the commands list and to update the history panel
   * with the new commands
   * <p>
   * Assumptions: called whenever there are new commands added and notified correctly by the
   * Controller
   */

  @Override
  public void notifyHistory() {
    StringBuilder sb = new StringBuilder();
    for (String history : control.getHistory()) {
      sb.append(history + "\n");
    }

    infoPanel.getHistoryText().setText(sb.toString());

  }

  /**
   * Purpose: used by the controller to notify the slogo that there is a new command which needs
   * animation created for it
   * <p>
   * Assumptions: assumed to be correctly called when a command has been run by the controller
   */

  @Override
  public void notifyAnimation() {
    try {
      animationHandler.createAnimation(control.getRecordTurtle());
    } catch (TurtleManagerException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }

  /**
   * Purpose: used by controller to notify the slogo that there the entire list of commands has been
   * run through, and now to play the sequential transition containing all of the animations
   * <p>
   * Assumptions: assumed to be called correctly after the entire list of commands has been iterated
   * through and that the sequential transition correctly contains all of the animations
   */

  @Override
  public void animationComplete() {
    animationHandler.playEntireAnimation();
  }

  /**
   * Purpose: Display error message for exceptions
   * <p>
   * Assumption: Called when an exception is thrown and displays the message detailing why the
   * exception was thrown
   *
   * @param type, Alert type that is displayed
   * @param msg,  the message of the exception that should be displayed with it
   */

  public static void showMessage(AlertType type, String msg) {
    Alert alert = new Alert(type, msg);
    Node alertNode = alert.getDialogPane();
    alertNode.setId("alert");
    alert.showAndWait();

  }

  /**
   * Purpose: clears the history of the command history text
   * <p>
   * Assumption: called whenever we want to clear the command history text
   */

  @Override
  public void clearHistory() {
    infoPanel.getHistoryText().setText("");
    control.resetHistory();
  }


}
