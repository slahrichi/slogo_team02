package Controller

import java.io.File;
import java.io.IOException;

/**
 * This Interface reads the files uploaded by the user and sends their commands to the InputParser
 */
public interface FileReader {

  /**
   * @param file the user uploads with commands to execute
   * @return List of Strings parsed from the file
   */
  public List<String> readTextFromFile(File file) {
    checkFile(file);
  }

  /**
   * @param file the user provided
   */
  public void checkFile(File file){

  }
}