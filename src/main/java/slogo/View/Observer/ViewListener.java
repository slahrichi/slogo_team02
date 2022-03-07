package slogo.View.Observer;

import javafx.scene.paint.Color;

/**
 * Purpose: A listener interface in the View that works in conjunction with the ViewPublisher
 * (observer) class that notifies the subscribers (specifically the Canvas and AnimationHandler
 * classes in this case)
 * <p>
 * Assumption: Assume that this listener is implemented into the subscribers we want it to notify
 * <p>
 * Dependencies: This class depends on the ViewPublisher in order to function and notify.
 * <p>
 * Example: When the background color of the canvas is selected, it sends out a notification of the
 * color to the CanvasView class.
 * <p>
 * Misc: N/A
 *
 * @author: Eric Xie
 */

public interface ViewListener {


  // described more in-depth where it's used in the concrete class, this updates the canvas background color
  public void updateCanvas(Color colorInput);

  // described more in-depth where it's used, updates the pen colors when drawing
  public void updatePen(Color colorInput);

}
