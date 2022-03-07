package slogo.View.Panels.Info;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Purpose: The purpose of this class is to hold the SideTitledPane subclass HelpPane, which
 * essentially manages the TitledPane that contains helpful information for users to work through
 * the program
 * <p>
 * Assumptions: I assume that this class is created correctly in the InformationalPanel, which holds
 * all the other titledpanes that have things to do with giving the user information
 * <p>
 * Dependencies: This class has dependencies on the InformationalPane class where its created and
 * imports multiple JavaFx Scene dependencies.
 * <p>
 * Example: This is used in the InformationPane class when creating every information pane on the
 * right side of the program. It has a Text object inside that contains information on how to use
 * the program.
 *
 * @author Eric Xie
 **/

public class HelpPane extends SideTitledPane {

  private Text helpText;

  /**
   * Purpose: Constructs a HelpPane object
   * <p>
   * Assumptions: I assume that this class is created correctly in the InformationalPanel, which
   * holds all the other Titled Panes that have things to do with giving the user information
   *
   * @param sideInput the VBox which the titled pane is added to
   **/

  public HelpPane(VBox sideInput) {
    super(sideInput);
    helpText = new Text();
    setUpHelpPane();
    setUpText();
  }

  // sets up the help pane

  private void setUpHelpPane() {
    getPane().setText("Help");
    getPane().setId("helpPane");
  }

  // sets up the text inside the help pane

  private void setUpText() {

    getGridPane().add(helpText, 0, 1);
    helpText.setText(
        "Welcome to the Team 2 SLogo GUI. Type into the shell or file editor on the left side"
            + "and click run to get started.");

  }


}
