package slogo;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import slogo.View.slogoGUI;


/**
<<<<<<< HEAD
 * Purpose: Where it all starts, automatically runs when the program is run and creates the slogoGUI
 * application and scene for displaying
 * <p>
 * Assumptions: Runs correctly whenever we click run and correctly constructs the slogoGUI for
 * displaying
 * <p>
 * Dependencies: Depends on JavaFX imports and on the SlogoGUI class for constructing a scene
 * <p>
 * Example: Click the run button to run the program.
=======
 * Main class that sets uo the animation and calls the slogo GUI
>>>>>>> 2156646c9231f9a738e29df3c8e8ac58000e8546
 */
public class Main extends Application {

  // useful names for constant values used
  public static final String TITLE = "Slogo Application";
  public static final String LANGUAGE = "English";
  public static final Dimension DEFAULT_SIZE = new Dimension(1500, 1000);
  private static final String LANGUAGE_RESOURCE_PATH = "slogo.languages.";
  private static final String EXAMPLE_PROGRAMS_PATH = "/examples";

  /**
   * Overrides the start with our own to create a slogoGUI application for displaying
   * <p>
   * Assumption: Assumed to correctly override the start method when we run the program and
   * correctly display the slogoGUI program
   *
   * @param stage, the Stage where we want to display our application on
   */


  @Override
  public void start(Stage stage) {

    slogoGUI turtleSim = new slogoGUI(stage, LANGUAGE);
    Scene scene = turtleSim.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    // give the window a title
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    stage.setScene(scene);
    //stage.setFullScreen(true);
    stage.show();

  }

  /**
   * Used to reset the entire slogoGUI application by creating a new one and setting the stage to
   * it
   * <p>
   * Assumed to be correctly used whenever the reset slogo button in the application is pressed
   *
   * @param stage, the Stage where we want to display the application on
   */

  public static void resetSlogo(Stage stage) {

    slogoGUI newSim = new slogoGUI(stage, LANGUAGE);
    Scene scene = newSim.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    stage.setTitle(TITLE);
    stage.setScene(scene);
    stage.show();


  }

  /**
   * Used to add the entire slogoGUI application by creating a new one and adding a Stage
   * <p>
   * Assumed to be correctly used whenever the add slogo button in the application is pressed
   */


  public static void addSlogo() {

    Stage newStage = new Stage();
    slogoGUI extraSim = new slogoGUI(newStage, LANGUAGE);
    Scene extraScene = extraSim.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    newStage.setScene(extraScene);
    newStage.show();

  }


  /**
   * Get command in a given language.
   */
  public String getCommand(String language, String command) {
    ResourceBundle resources = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PATH + language);
    return resources.getString(command);
  }

  /**
   * Get first line of given example program.
   */
  public String getExampleProgram(String category, String example) {
    // regular expression representing one or more whitespace characters (space, tab, or newline)
    final String NEWLINE = "\\n+";

    List<String> lines = readFile(
        String.format("%s/%s/%s.slogo", EXAMPLE_PROGRAMS_PATH, category, example), NEWLINE);
    return lines.get(0).trim();
  }


  // A method to test (and a joke :).
  public double getVersion() {
    return 0.001;
  }

  // this code is dense, hard to read, and throws exceptions so better to wrap in method
  private List<String> readFile(String filename, String delimiter) {
    try {
      String path = getClass().getResource(filename).toExternalForm();
      String data = new String(Files.readAllBytes(Paths.get(new URI(path))));
      return Arrays.asList(data.split(delimiter));
    } catch (URISyntaxException | IOException | NullPointerException e) {
      // NOT ideal way to handle exception, but this is just a simple test program
      System.out.println("ERROR: Unable to read input file " + e.getMessage());
      return Collections.emptyList();
    }
  }

    /*
    public static void main (String[] args) {
        Main m = new Main();
        System.out.println(m.getVersion());
        System.out.println(m.getCommand("English", "Forward"));
        System.out.println(m.getExampleProgram("loops", "star"));
    }*/
}
