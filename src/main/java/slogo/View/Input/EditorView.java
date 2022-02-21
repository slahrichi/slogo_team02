package slogo.View.Input;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class EditorView {

  private TextArea editorArea;
  private Label editorTitle;
  private final int editorColumnSize = 15;
  private final int editorRowSize = 25;

  public EditorView(VBox sidePanel) {

    editorTitle = new Label("Script Editor");
    editorArea = new TextArea();
    sidePanel.getChildren().addAll(editorTitle, editorArea);

  }

  private void setUpScript() {

    editorArea.setId("editorArea");
    editorArea.setPrefColumnCount(editorColumnSize);
    editorArea.setPrefRowCount(editorRowSize);

  }

  // takes in content and displays it on the script editor
  private void addContents(String fileContents) {

    editorArea.appendText(fileContents);

  }


  // takes the text and return it as a string to be parsed
  public String getContents() {

    return editorArea.getText();


  }


}
