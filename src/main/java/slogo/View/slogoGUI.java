package slogo.View;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.Control.Controller;
import slogo.View.Panels.CanvasView;
import slogo.View.Panels.Objects.TurtleView;
import slogo.View.Panels.InformationPanel;
import slogo.View.Panels.InputPanel;
import slogo.View.Panels.TitlePanel;

// class for creating the elements

public class slogoGUI implements ViewAPI {

  private static Controller turtleController;

  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String LANGUAGE_PACKAGE = "slogo.languages/";

  private String STYLESHEET;

  private TitlePanel titlePanel;
  private InputPanel inputPanel;
  private InformationPanel infoPanel;

  private ResourceBundle myResources;
  private BorderPane myRoot;

  private CanvasView turtleCanvas;
  private Stage myStage;
  private TurtleView turtleObject;


  public slogoGUI(Stage stage, String language) {


    turtleController = new Controller();

    myStage = stage;
    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LANGUAGE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(
        new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
    displayApp();


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
    myRoot.setRight(createInformationPanel());
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
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          } catch (NoSuchMethodException e) {
            e.printStackTrace();
          } catch (InstantiationException e) {
            e.printStackTrace();
          } catch (IllegalAccessException e) {
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
  }


  private StackPane createTurtleCanvas() {

    // NEED TO CREATE ITS OWN CLASS FOR THIS - TESTING THINGS AND UI SET UP RIGHT NOW

    StackPane canvasPane = new StackPane();
    turtleCanvas = new CanvasView(canvasPane);
    turtleObject = new TurtleView(canvasPane);
    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(0.6));

    return canvasPane;

  }

  private VBox createInformationPanel() {

    infoPanel = new InformationPanel(myStage);

    return infoPanel.getInfoBox();

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
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    turtleController.parseAndSetCommands(fileContent);
    turtleController.getAnimation().play();



  }

  /**
   *     Animation anim = turtleObject.updatePosition(turtleInput);
   *     anim.play();
   */


  // super class has an instance of the controller

  public static Controller getController(){
    return turtleController;
  }


  // main view becomes combine subviews total
  // singleton design pattern or mediator design pattern possibility to mention on the design analysis


}
