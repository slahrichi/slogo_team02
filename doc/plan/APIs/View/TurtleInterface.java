package slogo;

public interface TurtleInterface {

  /**
   * Front end UI of the SLogo simulation, updates the screen items and variables
   */

  // displays turtles on screen
  public default void displayTurtle() {

  }

  // displays the Menu bar of controls
  public default void displayMenuBar() {

  }

  // display the shell window where the users type
  public default void displayShellWindow() {

  }

  // display script window where previous commands are shown
  public default void displayScriptWindow() {

  }

  // uploaded file was faulty
  public default void displayExceptionMessage() {

  }

  // take in the input that the user wrote in the shell
  public default void commandSubmitted(String input) {

    setTurtleCommands(input);


  }

  // update the script window to show the most recently submitted comand
  public default void updateScriptWindow() {

  }

  public default void changeSpeed() {

    setUpAnimation();

  }


}
