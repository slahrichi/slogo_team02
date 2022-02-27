package slogo.View.Panels;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.View.Panels.Input.EditorView;
import slogo.View.Panels.Input.ShellView;

public class InputPanel {

  private VBox sidePanel;
  private Stage myStage;
  private ShellView shellView;
  private EditorView editorView;

  public InputPanel(Stage stageInput){

    myStage = stageInput;
    sidePanel = new VBox();
    sidePanel.setId("inputPanel");
    setUpPanel();

  }

  private void setUpPanel(){
    shellView = new ShellView(sidePanel);
    editorView = new EditorView(sidePanel);
    sidePanel.prefWidthProperty().bind(myStage.widthProperty().multiply(0.2));
  }

  public VBox getSidePanel(){
    return sidePanel;
  }

  public ShellView getShellView() {
    return shellView;
  }

  public EditorView getEditorView() {
    return editorView;
  }
}
