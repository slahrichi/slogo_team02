package slogo.View;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import slogo.Control.ControllerViewAPI;
import slogo.Control.TurtleRecord;
import slogo.Model.ModelExceptions;
import slogo.View.Configuration.FileReader;
import slogo.View.Exceptions.SlogoException;
import slogo.View.Panels.CanvasPanel;
import slogo.View.Panels.InformationPanel;
import slogo.View.Panels.InputPanel;
import slogo.View.Panels.TitlePanel;

// class for creating the elements

public class slogoGUI implements ViewAPI {


  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String LANGUAGE_PACKAGE = "slogo.languages/";
  private String STYLESHEET;

  public  final FileChooser FILE_CHOOSER = createChooser("*.slogo");
  private ControllerViewAPI control;
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
    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LANGUAGE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(
        new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
    displayApp();
    animationHandler = new AnimationHandler(canvasPanel);
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
    myRoot.setRight(createInformationPanel(control));
    myRoot.setBottom(createConfigButtons());
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
            e.printStackTrace();
          }
        }, myResources);
    Button clearHistory = makeButton("ClearHistory", event -> clearHistory(), myResources);
    Button loadFile = makeButton("LoadFile", event -> loadFilePressed(), myResources);
    Button saveFile = makeButton("SaveFile", event -> saveFilePressed(), myResources);

    playButton.setId("playButton");
    clearHistory.setId("clearHistory");
    loadFile.setId("loadFile");
    saveFile.setId("saveFile");

    configBox.getChildren().addAll(playButton, clearHistory, loadFile, saveFile);
    return configBox;

  }

  private void saveFilePressed() {
  }

  private void loadFilePressed() {

    try {
      File fileInput = FILE_CHOOSER.showOpenDialog(new Stage());
      if (fileInput != null) {
        FileReader initial = new FileReader(fileInput.getCanonicalPath());
        String fileContents = initial.getString();
        inputPanel.getEditorView().getTextArea().setText(fileContents);
      }
    } catch (SlogoException | IOException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }

  }


  private StackPane createTurtleCanvas() {

    canvasPanel = new CanvasPanel(myStage);

    return canvasPanel.getCanvasPanel();

  }

  private VBox createInformationPanel(ControllerViewAPI control) {

    infoPanel = new InformationPanel(myStage, control);

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
  public void clearConsole() {

  }

  @Override
  public void clearDisplay() {

  }

  @Override
  public void clearHistory() {

  }

  @Override
  public void changeBackgroundColor() {

  }

  @Override
  public void displayException(String errorMsg) {

  }

  @Override
  public void sendFileContents(String fileContent)
      throws Exception {


    control.parseAndRunCommands(fileContent);


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
  public void notifyAnimation(){
    animationHandler.createAnimation(control.getRecordTurtle());
  }

  @Override
  public void showMessage(AlertType type, String msg){
    Alert alert = new Alert(type, msg);
    alert.showAndWait();

  }




}
