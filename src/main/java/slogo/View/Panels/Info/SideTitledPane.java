package slogo.View.Panels.Info;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

// will be super class for the informational titled panes
public abstract class SideTitledPane {

  private GridPane variableGrid;


    public SideTitledPane(VBox sidePanel){




    }

  // add element method

  public abstract void addPane();


  public abstract void addVariable(int variable);



}
