package slogo.MasterPiece;

/**
 * Exception class that handles if the wrong / unavailable turtles are accessed. Is thrown with move
 * commands and Queries and in methods in TurtleManager class
 *
 * Shows that excpetions are handled for when the turtle being tried to accessed is not existent /
 * to handle any other TurtleManager Exceptions
 *
 * git commits: https://coursework.cs.duke.edu/compsci308_2022spring/slogo_team02/-/commit/cd25911161378afb69541ba40801e9084791a3ae
 * @author Haris Adnan
 */
public class TurtleManagerException extends Exception {

  /**
   * Exception for problematic input that would lead to the wrong / inaccessible turlte being
   * selected as the active turtle.
   *
   * @param message : message that is shown to user when this exception is thrown
   */
  public TurtleManagerException(String message) {
    super(message);

  }
}