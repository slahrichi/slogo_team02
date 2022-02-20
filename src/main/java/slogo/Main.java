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
import slogo.View.TurtleGUI;


/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {

    // useful names for constant values used
    public static final String TITLE = "Slogo Application";
    public static final String LANGUAGE = "English";
    public static final Dimension DEFAULT_SIZE = new Dimension(1000, 800);
    public static final String INITIAL_SIMULATION = "data/testSimulations/spreadingFireEDGE4.xml";

    @Override
    public void start (Stage stage) {

        TurtleGUI turtleSim = new TurtleGUI(stage, LANGUAGE);
        Scene scene = turtleSim.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height);

        // give the window a title
        stage.setTitle(TITLE);
        // add our user interface components to Frame and show it
        stage.setScene(scene);
        stage.show();

    }




    private static final String LANGUAGE_RESOURCE_PATH = "/slogo/languages/";
    private static final String EXAMPLE_PROGRAMS_PATH = "/examples";

    /**
     * Get command in a given language.
     */
    public String getCommand (String language, String command) {
        ResourceBundle resources = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PATH + language);
        return resources.getString(command);
    }

    /**
     * Get first line of given example program.
     */
    public String getExampleProgram (String category, String example) {
        // regular expression representing one or more whitespace characters (space, tab, or newline)
        final String NEWLINE = "\\n+";

        List<String> lines = readFile(String.format("%s/%s/%s.slogo", EXAMPLE_PROGRAMS_PATH, category, example), NEWLINE);
        return lines.get(0).trim();
    }


    // A method to test (and a joke :).
    public double getVersion () {
        return 0.001;
    }

    // this code is dense, hard to read, and throws exceptions so better to wrap in method
    private List<String> readFile (String filename, String delimiter) {
        try {
            String path = getClass().getResource(filename).toExternalForm();
            String data = new String(Files.readAllBytes(Paths.get(new URI(path))));
            return Arrays.asList(data.split(delimiter));
        }
        catch (URISyntaxException | IOException | NullPointerException e) {
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
