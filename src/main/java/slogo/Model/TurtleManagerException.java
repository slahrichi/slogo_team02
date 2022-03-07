package slogo.Model;

/**
 * Exception class that handles if the wrong / unavailable turtles are accessed. Is thrown with move
 * commands and Queries and in methods in TurtleManager class
 * @author Haris Adnan
 */
public class TurtleManagerException extends Exception {

  /**
   * Exception for problematic input that would lead to the wrong / inaccessible turlte being selected as
   * the active turtle.
   * @param message : message that is shown to user when this exception is thrown
   */
  public TurtleManagerException(String message) {
    super(message);

  }

  public TurtleManagerException(String message, Throwable cause) {
    super(message, cause);
  };


}
