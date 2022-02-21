package slogo.View;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.Model.Turtle;
import slogo.View.Input.EditorView;
import slogo.View.Input.ShellView;

// class for creating the elements

public class TurtleGUI implements ViewAPI {

  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String LANGUAGE_PACKAGE = "slogo.View.languages/";

  private String STYLESHEET;


  private ResourceBundle myResources;
  private BorderPane myRoot;
  private ShellView shellView;
  private EditorView editorView;
  private CanvasView turtleCanvas;
  private Stage myStage;
  private ImageView titleImage;


  public TurtleGUI(Stage stage, String language){

    myStage = stage;
    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LANGUAGE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
    titleImage = new ImageView();
    displayApp();


  }

  public Scene makeScene(int width, int height){

    Scene scene = new Scene(myRoot, width, height);
    scene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_PACKAGE + STYLESHEET).toExternalForm());

    return scene;

  }

  private void displayApp(){
    myRoot.setTop(makeTitle());
    myRoot.setLeft(createInputPanel());
    myRoot.setCenter(createTurtleCanvas());
    myRoot.setRight(createInformationPanel());
    myRoot.setBottom(createConfigButtons());

  }

  private Node makeTitle(){

    HBox TitleBox = new HBox();
    titleImage.setImage(new Image(getClass().getResource("/turtlePictures/turtleTitleImage.png").toString(), true));
    titleImage.setFitHeight(100);
    titleImage.setFitWidth(100);
    Label titleText = new Label("Team 9 SLogo Application");
    titleText.setId("titleText");
    TitleBox.getChildren().addAll(titleImage, titleText);
    TitleBox.setId("titleBox");

    return TitleBox;

  }

  //create buttons with their own names and actions
  public static Button makeButton(String labelName, EventHandler<ActionEvent> handler, ResourceBundle resources){

    Button buttonCreated = new Button();
    String buttonLabel = resources.getString(labelName);

    buttonCreated.setText(buttonLabel);
    buttonCreated.setOnAction(handler);

    return buttonCreated;

  }

  private Node createConfigButtons() {

    HBox configBox = new HBox();
    configBox.setId("configButtonBox");
    Button playButton = makeButton("PlayButton", event -> sendFileContents(editorView.getContents()), myResources);
    Button clearHistory = makeButton("ClearHistory", event -> clearHistoryPressed(), myResources);
    Button loadFile = makeButton("LoadFile", event -> loadFilePressed(), myResources);
    Button saveFile = makeButton("SaveFile", event -> saveFilePressed(), myResources);

    configBox.getChildren().addAll(playButton, clearHistory, loadFile, saveFile);
    return configBox;

  }

  private VBox createInputPanel() {

    VBox sidePanel = new VBox();
    sidePanel.setId("inputPanel");
    shellView = new ShellView(sidePanel);
    editorView = new EditorView(sidePanel);
    sidePanel.prefWidthProperty().bind(myStage.widthProperty().multiply(0.2));

    return sidePanel;

  }

  private StackPane createTurtleCanvas(){

    // NEED TO CREATE ITS OWN CLASS FOR THIS - TESTING THINGS AND UI SET UP RIGHT NOW

    StackPane canvasPane = new StackPane();
    turtleCanvas = new CanvasView(canvasPane);
    canvasPane.setId("canvasBox");
    canvasPane.prefWidthProperty().bind(myStage.widthProperty().multiply(0.6));

    return canvasPane;

  }

  private VBox createInformationPanel(){

    // NEED TO CREATE ITS OWN CLASS FOR THIS - TESTING THINGS AND UI SET UP RIGHT NOW


    // creating multiple titled pane to slide and show different elements
    VBox infoPanel = new VBox();
    infoPanel.setId("infoPanel");
    TitledPane variablePane = new TitledPane();
    variablePane.setExpanded(false);
    variablePane.setText("Variables");
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Variable 1 Here and Stats"), 0, 1);
    gridPane.add(new Label("Variable 2 Here and Stats"), 0, 2);
    variablePane.setContent(gridPane);
    infoPanel.getChildren().add(variablePane);
    infoPanel.prefWidthProperty().bind(myStage.widthProperty().multiply(0.2));

    return infoPanel;

  }


  @Override
  public void updatePosition(Turtle turtle, int xCoord, int yCoord) {

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
  public void sendFileContents(String fileContent) {

  }

  /**
   * All functions below are meant to be used in the CONTROLLER class, the CONTROLLER class will
   * handle the interconnections between View and the Functionality
   */

  private static void clearHistoryPressed(){

    System.out.println("Clear History works.");


  }

  private static void loadFilePressed(){

    System.out.println("Load file works.");


  }

  private static void saveFilePressed(){

    System.out.println("Save File works.");

  }

}
