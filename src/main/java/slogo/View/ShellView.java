package slogo.View;


import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;


public class ShellView {

  private TextArea shellArea;
  private String headCode = "slogo$";

  private static int shellColumnSize = 15;
  private static int shellRowSize = 10;


  public ShellView(VBox sidePanel){

    shellArea = new TextArea();
    shellArea.setId("textArea");
    shellArea.setPrefColumnCount(shellColumnSize);
    shellArea.setPrefRowCount(shellRowSize);
    sidePanel.getChildren().add(shellArea);

    setUpShell();

  }

  private void setUpShell(){

    shellArea.setOnKeyPressed(e -> shellKeyPress(e));
    shellArea.setOnMouseClicked(e -> shellArea.positionCaret(shellArea.getText().length()));
    shellArea.appendText(headCode);

  }

  private void shellKeyPress(KeyEvent e){


    // need to create key events for left, right, up, down
    // need to connect to the history of commands

  }


}
