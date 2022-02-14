package slogo;

import java.io.File;
import java.io.IOException;

/**
 * This Class Parses the input given to it by the user and has  methods that return the appropriate
 * command based off those inputs.
 * @author Haris Adnan
 */
public interface InputParser{

  /**
   * This Creates a command based off the instructions that the user inputs in the console
   * @param input : String input from the user
   * @return Command : Command matching the input
   */
  public Command createCommandFromText(String input){
    try {
      Command = parseText(input);
    } catch (InvalidUserInputException e) {
      // Display custom message to the user
    }
    return Command;
  }

  /**
   * This function parses the text into a Command
   * @param text : the text that is input by the user
   * @return Command : the command to be performed
   */
  public Command parseText(String text);



}