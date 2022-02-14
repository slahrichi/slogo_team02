package Controller;

/**
 * This Interface tries to parse all user input and translate it to commands
 * to be sent to the Turtle object. It also checks that the input is valid and handles
 * throwing and catching of appropriate Exceptions
 */
public interface InputParser{

  /**
   * This method takes the user input String and translates it to Command objects
   * @param input String parsed from the user
   * @return List of commands the turtle can execute
   */
  public List<Command> createCommandFromText(String input){
    catchInputException(input);
  }

  /**
   * This method checks if the input String is a valid command
   * @param input String parsed from the user
   */
  public void catchInputException(String input){

  }

}