package Exceptions;

/**
 * this Interface checks if the file is ready to be parsed it assumes the file is a valid .slogo
 * file
 */
public interface InvalidFileException {

  /**
   * this function throws an exception if it determines that the file is missing anything or
   * contains invalid commands
   *
   * @param .slogo file passed by the user
   */
  public void checkFile(File file) {

  }


}