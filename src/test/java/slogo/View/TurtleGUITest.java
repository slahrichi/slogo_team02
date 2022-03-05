package slogo.View;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class TurtleGUITest extends DukeApplicationTest {

  public static final String TITLE = "Slogo Application";
  public static final String LANGUAGE = "English";
  public static final Dimension DEFAULT_SIZE = new Dimension(1500, 1000);
  private static final String LANGUAGE_RESOURCE_PATH = "view";
  private static final String EXAMPLE_PROGRAMS_PATH = "/examples";
  private static final String textTest = "hello.";

  private TextArea myShellArea;
  private TextArea myScriptEditor;
  private Button myPlayButton;
  private ImageView myTurtle;
  private Button myLoadButton;
  private Button myResetButton;
  private Button myAddButton;
  private Button mySaveButton;





  @Override
  public void start(Stage stage){

    slogoGUI turtleSim = new slogoGUI(stage, LANGUAGE);
    Scene scene = turtleSim.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    // give the window a title
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    stage.setScene(scene);
    //stage.setFullScreen(true);
    stage.show();

    myShellArea = lookup("#textArea").query();
    myScriptEditor = lookup("#editorArea").query();
    myPlayButton = lookup("#PlayButton").query();
    myTurtle = lookup("#TurtleImage").query();
    myLoadButton = lookup("#LoadFile").query();
    mySaveButton = lookup("#SaveFile").query();
    myResetButton = lookup("#resetSlogo").query();
    myAddButton = lookup("#addSlogo").query();



  }


  @Test
  void testShellInput(){

    writeTo(myShellArea, textTest);
    assertEquals(myShellArea.getText(), textTest);


  }

  @Test
  void testTextEditor() {

    writeTo(myScriptEditor, textTest);
    assertEquals(myScriptEditor.getText(), textTest);

  }

  @Test
  void testFd50(){
    String fd50 = "fd 50";
    double initialY =  myTurtle.getY();
    writeTo(myScriptEditor,  fd50);
    clickOn(myPlayButton);
    double finalY =  myTurtle.getY();
    assertEquals(finalY, initialY + 50);

  }

  @Test
  void testRt90Fd50(){
    String rt90fd50 = "rt 90\nfd50";
    double initX = myTurtle.getX();
    writeTo(myScriptEditor, rt90fd50);
    clickOn(myPlayButton);
    double finalX = myTurtle.getX();

    assertEquals(finalX, initX + 50);
  }

  @Test
  void loadButtonPressed(){
    clickOn(myLoadButton);

    // happy path
    //clickOn(400, 1000);  // click on right file


    // bad path
    //clickOn(100, 1000); // click on wrong file

  }



  @Test
  void resetButtonPressed(){
    clickOn(myResetButton);

    // happy path - new stage created



  }

  @Test
  void addButtonPressed(){
    clickOn(myAddButton);
  }

  @Test
  void saveFile(){


    writeTo(myScriptEditor, "helloWorld");
    clickOn(mySaveButton);
    TextField titleInput = lookup("#titleInput").query();
    Button submitInput = lookup("#SubmitFile").query();
    writeTo(titleInput, "testFile");
    clickOn(submitInput);


  }





}