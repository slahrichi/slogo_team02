package slogo.View.Panels.Info;


import javafx.geometry.Insets;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

// will be super class for the informational titled panes
public abstract class SideTitledPane {

  protected static final int PANE_PADDING = 10;
  protected static final int PANE_GAP = PANE_PADDING / 2;

  private VBox sidePanel;
  private GridPane titledGrid;
  private TitledPane titledPane;


  public SideTitledPane(VBox sideInput){

      sidePanel = sideInput;
      titledPane = new TitledPane();
      titledGrid = new GridPane();

      setUpPane();
      setUpGrid();

      sidePanel.getChildren().add(titledPane);


  }

  private void setUpPane(){

    titledPane.setExpanded(false);
    titledPane.setContent(titledGrid);

  }

  private void setUpGrid(){

    titledGrid.setPadding(new Insets(PANE_PADDING));
    titledGrid.setHgap(PANE_GAP);
    titledGrid.setVgap(PANE_GAP);

  }



  protected abstract void addPane();


  protected abstract void addVariable(int variable);


  public TitledPane getPane(){
    return titledPane;
  }

  public GridPane getGridPane(){
    return titledGrid;
  }


}
