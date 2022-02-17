package Controller;

/**
 * This Class Parses the input given to it by the user and has  methods that return the appropriate
 * command based off those inputs. These commands are returned to the Turtle / Object.
 * It also checks that the input is valid and handles
 * throwing and catching of appropriate Exceptions
 * @author Haris Adnan & Saad Lahrichi
 */
public interface InputParser{
  /**
   * This Creates a command based off the instructions that the user inputs in the console
   * @param input : String input from the user
   * @return List<Command> : Command List matching the input
   */
  public Command createCommandFromText(String input){
    try {
      List<Command> CommandList = parseText(input);
    } catch (InvalidUserInputException e) {
      // Display custom message to the user
    }
    return CommandList;
  }

  /**
   * This function parses the text into a Command
   * @param text : the text that is input by the user
   * @return List<Command> : the command list to be performed
   */
  public List<Command> parseText(String text);

  }

}