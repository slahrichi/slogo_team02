package slogo.View.APIs;

/**
 * ViewAPI for the front end; The difference here from the ObserverViewAPI is that these methods are
 * usually called by the View end to send information to the controller; ObserverViewAPI holds the
 * methods that are utilized by the Command to notify the front end
 * <p>
 * Assumptions: To be used correctly by the slogoGUI class to send information to the Controller
 * whenever needed
 * <p>
 * Dependencies: Depends on the slogoGUI class and implemented by it for use in sending information
 * <p>
 * Example: An example of how to use this is when the run button is pressed; Essentially, the string
 * in the file contents at the time is taken and sent to the controller and parser for parsing.
 * <p>
 * Similar to the ObserverViewAPI, but mostly for front-end
 *
 * @author: Eric Xie
 */
public interface ViewAPI {

  /**
   * Used by frontend in clearing the command history panel when the slogo should be reset
   * <p>
   * Assumed to be used correctly whenever we need to clear the history
   */

  // clears history in the command history panel text area
  void clearHistory();

  /**
   * Used by front end to send the contents of the file editor input text area whenever the run
   * button is pressed
   * <p>
   * Assumed to called correctly whenever the run button is pressed in the GUI
   * <p>
   * throws the CommandException, which occurs when there's a problem with parsing the file contents
   * in the parser, this exception will then be displayed in a popup window
   *
   * @param fileContent the contents of the text area in the file editor
   */

  // takes file content string argument and sends it to the controller for parsing
  void sendFileContents(String fileContent)
      throws Exception;
}


