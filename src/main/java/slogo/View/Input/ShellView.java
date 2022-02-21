package slogo.View.Input;


import java.security.Key;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;


public class ShellView {

  private TextArea shellArea;
  private Label shellTitle;
  private ArrayList<String> commandHistory;
  private int currentCommandIndex = -1;

  private final String headCode = "slogo_team02 %";
  private final int shellColumnSize = 15;
  private final int shellRowSize = 10;


  public ShellView(VBox sidePanel){

    shellTitle = new Label("Shell");
    shellArea = new TextArea();
    sidePanel.getChildren().addAll(shellTitle, shellArea);
    setUpShell();

    commandHistory = new ArrayList<>();

  }

  private void setUpShell(){

    shellArea.setPrefColumnCount(shellColumnSize);
    shellArea.setPrefRowCount(shellRowSize);
    shellArea.setId("textArea");

    shellArea.setOnKeyPressed(e -> shellKeyPress(e));
    shellArea.setOnMouseClicked(e -> shellArea.positionCaret(shellArea.getText().length()));
    shellArea.addEventHandler(KeyEvent.KEY_PRESSED, evt -> backSpacePressed(evt));
    shellArea.appendText(headCode);

  }

  private void shellKeyPress(KeyEvent e) {

    // need to create key events for left, right, up, down
    // need to connect to the history of commands

    if (e.getCode() == KeyCode.ENTER) {
      e.consume();
      enterKeyPressed();

    } else if (e.getCode() == KeyCode.UP) {
      e.consume();
      upKeyPressed();

    } else if (e.getCode() == KeyCode.DOWN) {
      e.consume();
      downKeyPressed();

    }

  }

  private void backSpacePressed(KeyEvent e) {
    if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT) {
      // checks if backspace used to prevent it from deleting header
      if (shellArea.getCaretPosition()
          == shellArea.getText().lastIndexOf(headCode) + headCode.length() || shellArea.getSelectedText().length() != 0) {
        e.consume();
      }
    }
  }


  private void enterKeyPressed(){
    String command = getCommand();
    System.out.print(command);
    commandHistory.add(command);
    currentCommandIndex = commandHistory.size() - 1;
    shellArea.appendText(headCode);
    System.out.println(commandHistory);
    // give this string to the parser code here

  }

  private void upKeyPressed(){

    // clears the current command and replaces it with the one in the history if there is one
    if(currentCommandIndex >= 0){
      clearLine();
      shellArea.appendText(commandHistory.get(currentCommandIndex));
      currentCommandIndex--;
    }

  }

  private void downKeyPressed(){
    if(currentCommandIndex < commandHistory.size() - 1){
      clearLine();
      currentCommandIndex++;
      shellArea.appendText(commandHistory.get(currentCommandIndex));
    }


  }

  private String getCommand(){
    int caretPosition = shellArea.getText().lastIndexOf(headCode);
    String command = shellArea.getText(caretPosition + headCode.length(), shellArea.getText().length());
    return command;
  }

  private void clearLine(){
    String text = shellArea.getText();
    shellArea.setText(text.substring(0, text.lastIndexOf(getCommand())));
    shellArea.positionCaret(shellArea.getText().length());
  }


}
