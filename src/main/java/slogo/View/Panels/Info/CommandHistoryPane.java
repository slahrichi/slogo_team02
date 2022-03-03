package slogo.View.Panels.Info;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CommandHistoryPane extends SideTitledPane {

  private Text commandHistory;

  public CommandHistoryPane(VBox sideInput) {

    super(sideInput);

    commandHistory = new Text();
    setUpHistoryPane();
    setUpText();


  }


  private void setUpHistoryPane() {

    getPane().setText("Command History");
    getPane().setId("historyPane");
    getPane().setContent(commandHistory);

  }

  private void setUpText() {

    commandHistory.setId("commandHistoryText");
    commandHistory.setText("No commands yet.");


  }

  public Text getText() {
    return commandHistory;
  }

  @Override
  protected void addPane() {

  }

  @Override
  protected void addVariable(int variable) {

  }

}

