package slogo.View.Panels.Info;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BackgroundColorPane extends SideTitledPane{

  public BackgroundColorPane(VBox sideInput){
    super(sideInput);


    setUpColorPane();
    setUpColorGrid();

  }

  private void setUpColorPane(){

    getPane().setText("Background Colors");
    getPane().setId("backgroundColorPane");


  }

  private void setUpColorGrid(){

    getGridPane().add(new Label("Test Color Here"), 0, 1);
    getGridPane().add(new Label("Test Color 2"), 0, 2);

  }




  @Override
  protected void addPane() {

  }

  @Override
  protected void addVariable(int variable) {

  }

}
