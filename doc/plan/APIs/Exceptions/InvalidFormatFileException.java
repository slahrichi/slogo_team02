package Exceptions;

/**
 * this interface checks if the file is a .slogo file
 */
public interface InvalidFormatFileException {

  /**
   * the method throws an excpetion if the passed file's extension is not supported (in this case:
   * .slogo)
   *
   * @param file passed by the user
   */
  public checkFileFormat(File file)

}