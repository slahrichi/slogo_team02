package slogo;

/**
 * This interface allows for an exception to be thrown at the user when the command entered by the
 * user in the console is either incorrect or of the wrong format, and an error message is
 * displayed.
 *
 * @author Haris Adnan
 */
public interface InvalidUserInputException extends Throwable {

  /**
   * This method throws an excpetion at the user for the String input being of the wrong Format.
   */
  public invalidStringException();
}