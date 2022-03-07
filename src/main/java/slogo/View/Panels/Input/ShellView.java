package slogo.View.Panels.Input;


import static slogo.View.slogoGUI.showMessage;

import java.util.ArrayList;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import slogo.Control.Controller;

/**
 * Purpose: The ShellView encapsulates the shell input area in the input panel, which is located on
 * the left side of the GUI. It serves as the console for the user.
 * <p>
 * Assumptions: I assume that this is correctly created in the InputPanel class and passed the
 * correct VBox javafx node that it should be added to in order to be displayed correctly. I also
 * assume that the user uses this program to type in code one line at a time.
 * <p>
 * Dependencies: Depends on JavaFX scene and the Controller class as well as some other imports in
 * order to function
 * <p>
 * Example: Use this as a console, typing in variables or other commands; automatically runs the
 * input when you press enter to submit the command; it also remembers previous commands, which can
 * be accessed with the up and down keys
 * <p>
 * Exceptions: Catches command exceptions that can be caused when submitting commands that the user
 * runs in this shell
 *
 * @author Eric Xie
 **/

public class ShellView {

  private Controller shellControllerInstance;
  private TextArea shellArea;
  private Label shellTitle;
  private ArrayList<String> commandHistory;
  private int currentCommandIndex = -1;

  private final String headCode = "slogo_team02 % ";
  private static final int shellColumnSize = 15;
  private static final int shellRowSize = 10;


  /**
   * Purpose: The ShellView object constructor
   * <p>
   * Assumptions: I assume that this is correctly created in the InputPanel class and passed the
   * correct VBox javafx node that it should be added to in order to be displayed correctly. I also
   * assume that the user uses this program to type in code one line at a time.
   *
   * @param sidePanel VBox which the shell is added to
   **/

  public ShellView(VBox sidePanel) {

    //shellControllerInstance = ViewController.getController();
    shellTitle = new Label("Shell");
    shellArea = new TextArea();
    sidePanel.getChildren().addAll(shellTitle, shellArea);
    setUpShell();

    commandHistory = new ArrayList<>();

  }

  // sets up the shell / text area

  private void setUpShell() {

    shellArea.setPrefColumnCount(shellColumnSize);
    shellArea.setPrefRowCount(shellRowSize);
    shellArea.setId("textArea");

    shellArea.setOnKeyPressed(e -> shellKeyPress(e));
    shellArea.setOnMouseClicked(e -> shellArea.positionCaret(shellArea.getText().length()));
    shellArea.addEventHandler(KeyEvent.KEY_PRESSED, evt -> backSpacePressed(evt));
    shellArea.appendText(headCode);

  }

  // sets up the event and logic for when a key is pressed in the shell

  private void shellKeyPress(KeyEvent e) {

    // need to create key events for left, right, up, down
    // need to connect to the history of commands

    if (e.getCode() == KeyCode.ENTER) {
      e.consume();
      enterKeyPressed();

    } else if (e.getCode() == KeyCode.UP) {
      upKeyPressed();
      e.consume();

    } else if (e.getCode() == KeyCode.DOWN) {
      downKeyPressed();
      e.consume();
    }

  }

  // handles backspace event

  private void backSpacePressed(KeyEvent e) {
    if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT) {
      // checks if backspace used to prevent it from deleting header
      if (shellArea.getCaretPosition()
          == shellArea.getText().lastIndexOf(headCode) + headCode.length()
          || shellArea.getSelectedText().length() != 0) {
        e.consume();
      }
    }
  }

  // handles enter key event

  private void enterKeyPressed() {
    String command = getCommand();
    if (!command.equals("")) {
      commandHistory.add(command);
      currentCommandIndex = commandHistory.size() - 1;
    }
    shellArea.appendText(headCode);
    System.out.println(commandHistory);
    try {
      shellControllerInstance.parseAndRunCommands(command);

    } catch (Exception e) {
      showMessage(AlertType.ERROR, e.getMessage());
    }

  }

  // handles up key event and runs through command history to find previous commands

  private void upKeyPressed() {

    // clears the current command and replaces it with the one in the history if there is one
    if (currentCommandIndex >= 0) {
      clearLine();
      shellArea.appendText(commandHistory.get(currentCommandIndex));
      currentCommandIndex--;
    }

  }

  // handles down key event and runs through command history to find commands moved past

  private void downKeyPressed() {
    if (currentCommandIndex < commandHistory.size() - 1) {
      clearLine();
      currentCommandIndex++;
      shellArea.appendText(commandHistory.get(currentCommandIndex));
    }


  }

  // gets the line of where the command is and strips off the headCode in order to return the command itself

  private String getCommand() {
    int caretPosition = shellArea.getText().lastIndexOf(headCode);
    String command = shellArea.getText(caretPosition + headCode.length(),
        shellArea.getText().length());
    return command.strip();
  }

  // clears the line

  private void clearLine() {
    String text = shellArea.getText();
    shellArea.setText(text.substring(0, text.lastIndexOf(getCommand())));
    shellArea.positionCaret(shellArea.getText().length());
  }


}
