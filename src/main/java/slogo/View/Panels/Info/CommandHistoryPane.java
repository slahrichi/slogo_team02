package slogo.View.Panels.Info;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Purpose: The purpose of this class is to hold the SideTitledPane subclass CommandHistoryPane,
 * which essentially manages the TitledPane that contains the information of all commands that have
 * been ran
 * <p>
 * Assumptions: I assume that this class is created correctly in the InformationalPanel, which holds
 * all the other titledpanes that have things to do with giving the user information
 * <p>
 * Dependencies: This class has dependencies on the InformationalPane class where its created and
 * imports multiple JavaFx Scene dependencies.
 * <p>
 * Example: This is used in the InformationPane class when creating every information pane on the
 * right side of the program. It has a Text object inside for writing the Command History into.
 *
 * @author: Eric Xie
 **/

public class CommandHistoryPane extends SideTitledPane {

  private Text commandHistory;
  private ScrollPane scrollPane;

  private static final int SCROLL_LENGTH = 50;

  /**
   * Purpose: This is the CommandHistoryPane object constructor and creates the Scroll and TextPane
   * on which the command history is written
   * <p>
   * Assumptions: I assume that this class is created correctly in the InformationalPanel, which
   * holds all the other titled-panes that have things to do with giving the user information
   *
   * @param sideInput takes in the VBox which it is added onto
   **/

  public CommandHistoryPane(VBox sideInput) {

    super(sideInput);

    commandHistory = new Text();
    scrollPane = new ScrollPane();
    setUpScrollPane();
    setUpHistoryPane();
    setUpText();


  }

  // sets up the scroll pane where the text is put onto

  private void setUpScrollPane() {

    scrollPane.setContent(commandHistory);
    scrollPane.prefViewportHeightProperty().set(SCROLL_LENGTH);


  }

  // sets up the gridpane and makes the scrollpane the content

  private void setUpHistoryPane() {

    getPane().setText("Command History");
    getPane().setId("historyPane");
    getPane().setContent(scrollPane);

  }

  // sets up the text

  private void setUpText() {

    commandHistory.setId("commandHistoryText");
    commandHistory.setText("No commands yet.");


  }

  /**
   * Purpose: Made to return the text object that is in the scroll pane and in the outer titled
   * pane
   * <p>
   * Assumptions: Assumed to be used when the text object is needed to be changed
   *
   * @return commandHistory the Text object created that holds the command history
   **/

  public Text getText() {
    return commandHistory;
  }


}

