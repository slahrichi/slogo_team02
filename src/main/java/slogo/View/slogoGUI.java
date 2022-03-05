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
import slogo.View.Configuration.SlogoReader;
import slogo.View.Configuration.SlogoWriter;
import slogo.View.Exceptions.SlogoException;
import slogo.View.Panels.CanvasPanel;
import slogo.View.Panels.InformationPanel;
import slogo.View.Panels.InputPanel;
import slogo.View.Panels.TitlePanel;

// class for creating the elements

public class slogoGUI implements ViewAPI, ObserverViewInterface {


  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String VIEW_RESOURCE_PACKAGE = "view/";
  private String STYLESHEET;

  public  final FileChooser FILE_CHOOSER = createChooser("*.slogo");
  private ControllerAPI control;
  private TitlePanel titlePanel;
  private InputPanel inputPanel;
  private InformationPanel infoPanel;
  private CanvasPanel canvasPanel;
  private BorderPane myRoot;
  private ResourceBundle myResources;
  private Stage myStage;
  private AnimationHandler animationHandler;


  public slogoGUI(Stage stage, String language) {

    control = new Controller(this);

    //viewControlInstance = ViewController.getController();
    myStage = stage;
    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + VIEW_RESOURCE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(
        new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
    displayApp();
    animationHandler = new AnimationHandler(canvasPanel);
    displayInformation();

  }

  public Scene makeScene(int width, int height) {

    Scene scene = new Scene(myRoot, width, height);
    scene.getStylesheets()
        .add(getClass().getResource(DEFAULT_RESOURCE_PACKAGE + STYLESHEET).toExternalForm());

    return scene;

  }

  private void displayApp() {
    myRoot.setTop(makeTitle());
    myRoot.setLeft(createInputPanel());
    myRoot.setCenter(createTurtleCanvas());
    myRoot.setBottom(createConfigButtons());
  }

  private void displayInformation() {
    myRoot.setRight(createInformationPanel());
  }


  private HBox makeTitle(){

    titlePanel = new TitlePanel();
    return titlePanel.getTitleBox();

  }

  private VBox createInputPanel() {

    inputPanel = new InputPanel(myStage);
    return inputPanel.getSidePanel();

  }

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

    configBox.getChildren().addAll(playButton, clearHistory, loadFile, saveFile, resetCanvas, resetSlogo, addSlogo);
    return configBox;

  }

  private void saveFilePressed() {
    SlogoWriter initial = new SlogoWriter(inputPanel.getEditorView().getContents(), myResources);
  }

  private void loadFilePressed() {

    try {
      File fileInput = FILE_CHOOSER.showOpenDialog(new Stage());
      if (fileInput != null) {
        SlogoReader initial = new SlogoReader(fileInput.getCanonicalPath());
        String fileContents = initial.getString();
        inputPanel.getEditorView().getTextArea().setText(fileContents);
      }
    } catch (SlogoException | IOException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }

  }

  private void resetCanvas(){
    canvasPanel.getCanvasView().clearCanvas();
    try {
      control.parseAndRunCommands("home");
    } catch (Exception e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
    infoPanel.getHistoryText().setText("");
    inputPanel.getEditorView().getTextArea().setText("");


  }


  private StackPane createTurtleCanvas() {

    canvasPanel = new CanvasPanel(myStage);

    return canvasPanel.getCanvasPanel();

  }

  private VBox createInformationPanel() {

    infoPanel = new InformationPanel(myStage, animationHandler, canvasPanel.getCanvasView());

    return infoPanel.getInfoBox();

  }

  private FileChooser createChooser(String extension){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Data File");
    fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
    fileChooser.getExtensionFilters().setAll(
        new ExtensionFilter("Text Files", extension));

    return fileChooser;

  }


  @Override
  public void clearHistory() {

  }

  @Override
  public void sendFileContents(String fileContent)
      throws Exception {

    try{
      control.parseAndRunCommands(fileContent);

    }
    catch(CommandException e){
      showMessage(AlertType.ERROR, e.getMessage());
    }


  }

  @Override
  public void notifyHistory() {
    StringBuilder sb = new StringBuilder();
    for (String history : control.getHistory()){
      sb.append(history + "\n");
    }

    infoPanel.getHistoryText().setText(sb.toString());

  }

  @Override
  public void notifyAnimation() {
    try {
      animationHandler.createAnimation(control.getRecordTurtle());
    } catch (TurtleManagerException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }

  @Override
  public void animationComplete() { animationHandler.playEntireAnimation();}

  @Override
  public void showMessage(AlertType type, String msg){
    Alert alert = new Alert(type, msg);
    Node alertNode = alert.getDialogPane();
    alertNode.setId("alert");
    alert.showAndWait();

  }


}
