package slogo.View.Panels.Info;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Observer.ViewPublisher;

/**
 * Purpose: The purpose of this class is to hold the SideTitledPane subclass BackgroundColorPane,
 * which essentially manages the TitledPane that contains the user tools for changing the canvas
 * color
 * <p>
 * Assumptions: I assume that this class is created correctly in the InformationalPanel, which holds
 * all the other titledpanes that have things to do with giving the user information
 * <p>
 * Dependencies: This class has dependencies on the InformationalPane class where its created and
 * imports multiple JavaFx event and Scene dependencies. It also relies on the ViewPublisher class
 * to help notify the CanvasView of a color change.
 * <p>
 * Example: This is used in the InformationPane class when creating every information pane on the
 * right side of the program. It has a colorpicker on the inside that changes the background color
 * of the canvas when selected.
 *
 * @author Eric Xie
 */

public class BackgroundColorPane extends SideTitledPane {

  private ColorPicker colorPicker;
  private ViewPublisher vp;

  /**
   * Purpose: This is the BackgroundColorPane object constructor, which extends the SideTitledPane
   * super class and has its own characteristics of a ColorPicker and ViewPublisher observer class
   * object added.
   * <p>
   * Assumptions: I assume that this class is created correctly in the InformationalPanel, which
   * holds all the other titledpanes that have things to do with giving the user information
   *
   * @param canvasView takes in the canvasview object we want to change
   * @param sideInput  VBox where we'll be adding the pane to
   **/

  public BackgroundColorPane(VBox sideInput, CanvasView canvasView) {
    super(sideInput);

    colorPicker = new ColorPicker();
    vp = new ViewPublisher();
    vp.addObserver(canvasView);

    setUpColorPane();
    setUpColorGrid();

  }

  // sets up the color pane

  private void setUpColorPane() {

    getPane().setText("Background Colors");
    getPane().setId("backgroundColorPane");


  }

  // sets up the colorgrid and colorpicker we use, event handler for detecting when a new color is chosen
  // and calls the publisher to notify the listeners

  private void setUpColorGrid() {

    getGridPane().add(colorPicker, 0, 1);
    colorPicker.setOnAction(new EventHandler() {
      public void handle(Event t) {
        Color c = colorPicker.getValue();
        vp.updateColor(c);
      }
    });

  }


}
