package slogo.View.Configuration;

import static slogo.View.slogoGUI.makeButton;
import static slogo.View.slogoGUI.showMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Purpose: The purpose of this class is that it handles the writing of .slogo files by retrieving
 * the editor contents and saving it as a .slogo file
 * <p>
 * Assumption: We assume that the string being passed to the SlogoWriter is the correct string of
 * the program that the user wants to save. It doesn't check if the String is correct or not.
 * <p>
 * Dependencies: This class depends on multiple file imports as well as javaFx stage effects in
 * order to create a window for user input. It then has some event handlers to check when the submit
 * input button is pressed.
 * <p>
 * Example: When the save button is pressed, the users inserts a title and clicks submit file to
 * create the file. This file is then saved in the data folder under saves.
 * <p>
 * Misc: N/A
 *
 * @author: Eric Xie
 */

public class SlogoWriter {

  public static final int WIDTH = 400;
  public static final int HEIGHT = 100;
  private final Stage myStage;
  private final VBox myRoot;
  private final ResourceBundle myResources;


  private String editorContents;



  /**
   * Purpose: The purpose of this class is that it constructs SlogoWriters
   * <p>
   * Assumption: We assume that the string being passed to the SlogoWriter is the correct string of
   * the program that the user wants to save. It doesn't check if the String is correct or not.
   * <p>
   * Dependencies: This class depends on multiple file imports as well as javaFx stage effects in
   * order to create a window for user input. It then has some event handlers to check when the submit
   * input button is pressed.
   * <p>
   * Example: This slogowriter object is created in the slogoGUI to create a new slogo file of the
   * user's choice
   * <p>
   * Misc: N/A
   *
   * @param fileInput string of the editor contents to be made into a file
   * @param resources ResourceBundle for name of buttons
   *
   */

  public SlogoWriter(String fileInput, ResourceBundle resources) {

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

  // sets up window for user inputs
  private void inputsAdded() {
    TextField title = new TextField(myResources.getString("SaveTitle"));
    title.setId("titleInput");
    Button submit = makeButton("SubmitFile",
        event -> submitButtonPressed(title.getCharacters().toString()),
        myResources);
    myRoot.getChildren().addAll(title, submit);
  }

  // handles when the submit button is clicked in the user input window
  private void submitButtonPressed(String title) {
    myStage.close();
    try {
      FileWriter fw = new FileWriter(new File("data/saves", title + ".slogo"));
      fw.write(editorContents);
      fw.close();
    } catch (IOException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }



}
