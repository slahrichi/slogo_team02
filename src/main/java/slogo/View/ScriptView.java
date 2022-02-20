package slogo.View;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ScriptView {

  private TextArea scriptArea;
  private final int shellColumnSize = 15;
  private final int shellRowSize = 20;

  public ScriptView(VBox sidePanel){

    scriptArea = new TextArea();
    scriptArea.setId("scriptArea");
    scriptArea.setPrefColumnCount(shellColumnSize);
    scriptArea.setPrefRowCount(shellRowSize);
    sidePanel.getChildren().add(scriptArea);

  }





}
