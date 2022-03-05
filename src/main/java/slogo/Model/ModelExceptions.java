package slogo.Model;

/**
 *
 * Handles Turtles exceptions relationg to the turtl and the postion of the Turtle.
 * @author Haris Adnan
 */
public class ModelExceptions extends Exception{

  /**
   * Model Exception thrown when turtle is out of bounds, is thrown with every move command
   * @param message
   */
    public ModelExceptions(String message) {
      super(message);

    }

    public ModelExceptions(String message, Throwable cause) {
      super(message, cause);
    };

}

