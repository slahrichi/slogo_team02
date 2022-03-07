package slogo.View.Panels.Input;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * Purpose: The EditorView class encapsulates the input panel's editor, which is a large text area
 * where the uploaded file will display; furthermore allows the user to edit whatever commands they
 * want in the area as well
 * <p>
 * Assumptions: I assume that this is correctly created in the InputPanel class and passed the
 * correct VBox javafx node that it should be added to in order to be displayed correctly
 * <p>
 * Dependencies: Depends on the InputPanel class where it is constructed and multiple Javafx scene
 * imports
 * <p>
 * Example: User can type in commands and upload files, which contents will appear in the file
 * editor; essentially a large text area that the user can use
 **/

public class EditorView {

  private TextArea editorArea;
  private Label editorTitle;
  private final int editorColumnSize = 15;
  private final int editorRowSize = 20;

  /**
   * Purpose: The EditorView object constructor
   * <p>
   * Assumptions: I assume that this is correctly created in the InputPanel class and passed the
   * correct VBox javafx node that it should be added to in order to be displayed correctly
   *
   * @param sidePanel VBox where the editor object is added to
   **/

  public EditorView(VBox sidePanel) {

    editorTitle = new Label("Script Editor");
    editorArea = new TextArea();
    sidePanel.getChildren().addAll(editorTitle, editorArea);
    setUpScript();

  }

  // sets up the script area

  private void setUpScript() {

    editorArea.setPrefColumnCount(editorColumnSize);
    editorArea.setPrefRowCount(editorRowSize);
    editorArea.setId("editorArea");


  }


  /**
   * Purpose: retrieves the contents of the editor
   * <p>
   * Assumptions: assumed that its called whenever we need the editor's contents and called
   * correctly
   *
   * @return String of the editor area's contents
   **/

  public String getContents() {

    return editorArea.getText();


  }

  /**
   * Purpose: Retrieves the text area
   * <p>
   * Assumptions: I assume that this is correctly called whenever we need the text area itself
   *
   * @return TextArea editorArea
   **/

  public TextArea getTextArea() {
    return editorArea;
  }


}
