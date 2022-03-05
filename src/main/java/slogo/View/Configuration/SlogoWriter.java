package slogo.View.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SlogoWriter {

  public static final int WIDTH = 400;
  public static final int HEIGHT = 100;
  private final Stage myStage;
  private final VBox myRoot;
  private String myTitle;
  private ResourceBundle myResources;
  private FileWriter fw;


  private String editorContents;

  public SlogoWriter(String fileInput, ResourceBundle resources){

    editorContents = fileInput;
    myStage = new Stage();
    myRoot = new VBox();
    myResources = resources;
    editorContents = fileInput;
    inputsAdded();
    Scene scene = new Scene(myRoot, WIDTH, HEIGHT);
    myStage.setScene(scene);
    myStage.show();



  }

  private void inputsAdded() {
    TextField title = new TextField(myResources.getString("SaveTitle"));
    Button submit = makeButton("SubmitFile",
        event -> submitButtonPressed(title.getCharacters().toString()),
        myResources);
    myRoot.getChildren().addAll(title, submit);
  }

  private void submitButtonPressed(String title) {
    myStage.close();
    try{
      fw = new FileWriter(new File("data/saves", title + ".slogo"));
      fw.write(editorContents);
      fw.close();
    }
    catch(IOException e){
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }



  public static Button makeButton(String labelName, EventHandler<ActionEvent> handler,
      ResourceBundle resources) {

    Button buttonCreated = new Button();
    String buttonLabel = resources.getString(labelName);

    buttonCreated.setText(buttonLabel);
    buttonCreated.setOnAction(handler);

    return buttonCreated;

  }

  public void showMessage(AlertType type, String msg){
    Alert alert = new Alert(type, msg);
    alert.showAndWait();

  }

}
