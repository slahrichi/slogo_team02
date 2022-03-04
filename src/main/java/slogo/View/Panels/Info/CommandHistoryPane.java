package slogo.View.Panels.Info;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CommandHistoryPane extends SideTitledPane {

  private Text commandHistory;
  private ScrollPane scrollPane;

  private static final int SCROLL_LENGTH = 50;

  public CommandHistoryPane(VBox sideInput) {

    super(sideInput);

    commandHistory = new Text();
    scrollPane = new ScrollPane();
    setUpScrollPane();
    setUpHistoryPane();
    setUpText();


  }

  private void setUpScrollPane() {

    scrollPane.setContent(commandHistory);
    scrollPane.prefViewportHeightProperty().set(SCROLL_LENGTH);


  }


  private void setUpHistoryPane() {

    getPane().setText("Command History");
    getPane().setId("historyPane");
    getPane().setContent(scrollPane);

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

