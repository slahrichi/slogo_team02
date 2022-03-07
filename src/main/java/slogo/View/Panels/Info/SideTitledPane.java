package slogo.View.Panels.Info;


import javafx.geometry.Insets;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 * Purpose: This is the super class for Titled Panes that I created in order to handle similarities
 * between all the informational titled panes I was going to create for the right side of the GUI
 * <p>
 * Assumptions: I assume that each titled pane created takes in a VBox, which is where it'll be
 * added to in order for it to show up in the display; furthermore, I assume that the VBox that its
 * passed is the correct VBox that is on the right side of the program
 * <p>
 * Dependencies: This superclass is utilized by all its subclasses titled panes and is used in the
 * InformationPanel class to create all the various kinds of informational panes
 * <p>
 * Example: We never call/create this abstract class directly and construct its children instead;
 * however each of them takes on characteristics in setting up
 *
 * @author Eric Xie
 **/

// will be super class for the informational titled panes
public abstract class SideTitledPane {

  protected static final int PANE_PADDING = 10;
  protected static final int PANE_GAP = PANE_PADDING / 2;

  private VBox sidePanel;
  private GridPane titledGrid;
  private TitledPane titledPane;

  /**
   * Purpose: The superclass constructor for side titled panes
   * <p>
   * Assumptions: I assume that each titled pane created takes in a VBox, which is where it'll be
   * added to in order for it to show up in the display; furthermore, I assume that the VBox that
   * its passed is the correct VBox that is on the right side of the program
   * <p>
   *
   * @param sideInput VBox we want the panel to be in
   **/


  public SideTitledPane(VBox sideInput) {

    sidePanel = sideInput;
    titledPane = new TitledPane();
    titledGrid = new GridPane();

    setUpPane();
    setUpGrid();

    sidePanel.getChildren().add(titledPane);


  }

  // sets up the pane

  private void setUpPane() {

    titledPane.setExpanded(false);
    titledPane.setContent(titledGrid);

  }

  // sets up the grid inside the pane that holds the content

  private void setUpGrid() {

    titledGrid.setPadding(new Insets(PANE_PADDING));
    titledGrid.setHgap(PANE_GAP);
    titledGrid.setVgap(PANE_GAP);

  }

  // used by subclasses to retrieve title pane

  protected TitledPane getPane() {
    return titledPane;
  }

  // used by subclasses to retrieve gridpane inside title pane

  protected GridPane getGridPane() {
    return titledGrid;
  }


}
