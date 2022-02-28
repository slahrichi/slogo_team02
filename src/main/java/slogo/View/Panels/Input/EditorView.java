package slogo.View.Panels.Input;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class EditorView {

  private TextArea editorArea;
  private Label editorTitle;
  private final int editorColumnSize = 15;
  private final int editorRowSize = 20;

  public EditorView(VBox sidePanel) {

    editorTitle = new Label("Script Editor");
    editorArea = new TextArea();
    sidePanel.getChildren().addAll(editorTitle, editorArea);
    setUpScript();

  }

  private void setUpScript() {

    editorArea.setPrefColumnCount(editorColumnSize);
    editorArea.setPrefRowCount(editorRowSize);
    editorArea.setId("editorArea");


  }

  // takes in content and displays it on the script editor
  private void addContents(String fileContents) {

    editorArea.appendText(fileContents);

  }


  // takes the text and return it as a string to be parsed
  public String getContents() {

    return editorArea.getText();


  }

  public TextArea getTextArea(){
    return editorArea;
  }


}
