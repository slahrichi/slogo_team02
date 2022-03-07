package slogo.View.Panels.Info;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import slogo.View.AnimationHandler;
import slogo.View.Observer.ViewPublisher;

/**
 * Purpose: The purpose of this class is to hold the SideTitledPane subclass PenColorPane, which
 * essentially manages the TitledPane that contains the tool for users to change the pen color of
 * the turtle
 * <p>
 * Assumptions: I assume that this class is created correctly in the InformationalPanel, which holds
 * all the other titled panes that have things to do with giving the user information
 * <p>
 * Dependencies: This class has dependencies on the InformationalPane class where its created and
 * imports multiple JavaFx Scene and Event dependencies. Also relies on the ViewPublisher observer
 * class.
 * <p>
 * Example: This is used in the InformationPane class when creating every information pane on the
 * right side of the program. It has a ColorPicker object inside with an event handler that notifies
 * the listeners (animation handler) whenever the color is changed.
 *
 * @author Eric Xie
 **/

public class PenColorPane extends SideTitledPane {

  private ViewPublisher vp;
  private ColorPicker colorPicker;


  /**
   * Purpose: The constructor for PenColorPane objects
   * <p>
   * Assumptions: I assume that this class is created correctly in the InformationalPanel, which
   * holds all the other titledpanes that have things to do with giving the user information
   *
   * @param sideInput        The VBox which the pane is added to
   * @param animationHandler the animation handler object where the pen color is changed
   **/

  public PenColorPane(VBox sideInput, AnimationHandler animationHandler) {
    super(sideInput);

    colorPicker = new ColorPicker();
    vp = new ViewPublisher();
    vp.addObserver(animationHandler);
    setUpPenPane();
    setUpColorGrid();

  }

  // sets up the pen pane

  private void setUpPenPane() {
    getPane().setText("Pen Colors");
    getPane().setId("penPane");
  }

  // sets up the color grid, event handler, and notifies listeners when the color is changed

  private void setUpColorGrid() {

    getGridPane().add(colorPicker, 0, 1);
    colorPicker.setOnAction(new EventHandler() {
      public void handle(Event t) {
        Color c = colorPicker.getValue();
        vp.updatePen(c);
      }
    });

  }
}
