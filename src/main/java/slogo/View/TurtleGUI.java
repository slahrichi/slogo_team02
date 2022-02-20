package slogo.View;

import static slogo.View.TurtleView.doTest;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditorSkin.Command;

// class for creating the elements

public class TurtleGUI {

  public static final String DEFAULT_RESOURCE_PACKAGE = "/";
  public static final String LANGUAGE_PACKAGE = "slogo.languages/";
  private String STYLESHEET;


  private ResourceBundle myResources;
  private BorderPane myRoot;
  private ShellView shellNode;
  private Canvas turtleCanvas;
  private CommandHistoryView commandHistory;


  public TurtleGUI(String language){

    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LANGUAGE_PACKAGE + language);
    myRoot = new BorderPane();
    myRoot.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
    STYLESHEET = "stylesheet.css";
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
    Label titleText = new Label("Team 9 SLogo Application");
    titleText.setId("titleText");
    TitleBox.getChildren().add(titleText);
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
    Button playButton = makeButton("PlayButton", event -> doTest(), myResources);
    Button clearHistory = makeButton("ClearHistory", event -> doTest(), myResources);
    Button loadFile = makeButton("LoadFile", event -> doTest(), myResources);
    Button saveFile = makeButton("SaveFile", event -> doTest(), myResources);

    configBox.getChildren().addAll(playButton, clearHistory, loadFile, saveFile);
    return configBox;

  }

  private VBox createInputPanel() {

    VBox sidePanel = new VBox();
    sidePanel.setId("inputPanel");
    shellNode = new ShellView(sidePanel);
    commandHistory = new CommandHistoryView();


    return sidePanel;

  }

  private Canvas createTurtleCanvas(){


    turtleCanvas = new Canvas(400, 400);
    GraphicsContext gc = turtleCanvas.getGraphicsContext2D();
    gc.setFill(Color.BLUE);
    gc.fillRect(0, 0, 400, 400);

    return turtleCanvas;

  }

  private VBox createInformationPanel(){

    // creating multiple titled pane to slide and show different elements
    VBox infoPanel = new VBox();
    infoPanel.setId("infoPanel");
    TitledPane variablePane = new TitledPane();
    infoPanel.getChildren().add(variablePane);

    return infoPanel;

  }





}
