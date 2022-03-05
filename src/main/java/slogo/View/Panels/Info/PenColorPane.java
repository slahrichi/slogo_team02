package slogo.View.Panels.Info;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import slogo.View.AnimationHandler;
import slogo.View.Observer.ViewPublisher;

public class PenColorPane extends SideTitledPane{

  private ViewPublisher vp;
  private ColorPicker colorPicker;


  public PenColorPane(VBox sideInput, AnimationHandler animationHandler) {
    super(sideInput);

    colorPicker = new ColorPicker();
    vp = new ViewPublisher();
    vp.addObserver(animationHandler);
    setUpPenPane();
    setUpColorGrid();

  }

  private void setUpPenPane(){
    getPane().setText("Pen Colors");
    getPane().setId("penPane");
  }

  private void setUpColorGrid(){

    getGridPane().add(colorPicker, 0, 1);
    colorPicker.setOnAction(new EventHandler() {
      public void handle(Event t) {
        Color c = colorPicker.getValue();
        vp.updatePen(c);
      }
    });

  }

  @Override
  protected void addPane() {

  }

  @Override
  protected void addVariable(int variable) {

  }
}
