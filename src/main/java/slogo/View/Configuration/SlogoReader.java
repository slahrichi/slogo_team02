package slogo.View.Configuration;

import static slogo.View.slogoGUI.showMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.scene.control.Alert.AlertType;
import slogo.View.Exceptions.SlogoException;


/**
 * Purpose: The purpose of this class is that it handles the reading of .slogo files by parsing
 * through the file and returning the String back to the UI.
 * <p>
 * Assumption: We catch the IOException in both the slogoGUI (where its called) and here, but we
 * assume that the user will select a file with the correct file extension of slogo. Furthermore, we
 * assume that the file input has the correct format and nothing that stops the file from being
 * read.
 * <p>
 * Dependencies: This class depends on multiple file imports as well as the slogoGUI's methods such
 * as the showMessage method to display exceptions that have been caught.
 * <p>
 * Example: When the load file button is clicked and a correct file is selected, the FileReader
 * object takes it in and parses through it
 * <p>
 * Misc: N/A
 *
 * @author: Eric Xie
 */

public class SlogoReader {

  private String fileContents;
  private Path fileName;

  /**
   * Purpose: Constructs SlogoReader object that reads the String fileInput name and parses through
   * the file, storing the file contents into a String
   * <p>
   * Assumption: We catch the IOException in both the slogoGUI (where its called) and here, but we
   * assume that the user will select a file with the correct file extension of slogo. Furthermore,
   * we assume that the file input has the correct format and nothing that stops the file from being
   * read.
   * <p>
   * Dependencies: This class depends on multiple file imports as well as the IO Exception class to
   * throw exceptions. Also depends on the SlogoGUI's showMessage method to display exception
   * messages.
   * <p>
   * Example: Created FileReader in the slogoGUI when we clicked on the LoadFile and selecting a
   * file
   * <p>
   *
   * @param file a string of the file name
   *
   * @author: Eric Xie
   */

  public SlogoReader(String file) throws IOException {

    try {
      fileName = Path.of(file);
      parseFile();
    } catch (SlogoException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }

  // parses through the file by reading the file given and catches any IOException
  private void parseFile() throws IOException {

    try {
      fileContents = Files.readString(fileName);
    } catch (SlogoException e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }


  }

  /**
   * Purpose: The purpose of this class to retrieve the file contents string
   * <p>
   * Assumption: We assume the file parser correctly retrieved the file contents string
   * <p>
   * Dependencies: Used in slogoGUI to retrive string
   * <p>
   * Example: After creating FileReader object in slogoGUI, we call the .getString() to retrieve the
   * file contents
   * <p>
   * Misc: N/A
   *
   * @return String of file contents
   *
   * @author: Eric Xie
   */

  public String getString() {
    return fileContents;
  }


}
