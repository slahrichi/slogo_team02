package slogo.View.Panels.Info;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelpPane extends SideTitledPane{

  private Text helpText;

  public HelpPane(VBox sideInput) {
    super(sideInput);
    helpText = new Text();
    setUpHelpPane();
    setUpText();
  }

  private void setUpHelpPane(){
    getPane().setText("Help");
    getPane().setId("helpPane");
  }

  private void setUpText(){

    getGridPane().add(helpText, 0 , 1);
    helpText.setText("Help information here");

  }

  @Override
  protected void addPane() {

  }

  @Override
  protected void addVariable(int variable) {

  }

}
