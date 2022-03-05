package slogo.View;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
  void loadButtonPressed(){
    clickOn(myLoadButton);

  }

  @Test
  void resetButtonPressed(){
    clickOn(myResetButton);

    // happy path - new stage created
    assertEquals()
  }





}