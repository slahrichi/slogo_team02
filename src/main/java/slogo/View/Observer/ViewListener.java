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


  /**
   * Used by the ViewPublisher when a change has been notified and is implemented by the CanvasView
   * class to update the canvas
   * <p>
   * Assumed to be used correctly and called correctly whenever the color picker detects that a new
   * color has been chosen
   *
   * @param colorInput Color that we want to canvas to be
   */

  void updateCanvas(Color colorInput);

  /**
   * Used by the ViewPublisher when a change has been notified and is implemented by the
   * Animationhandler class
   * <p>
   * Assumed to be used and called correctly whenever the pen color colorpicker is notified of a
   * color change
   *
   * @param colorInput color that we want the pen to be
   */

  // described more in-depth where it's used, updates the pen colors when drawing
  void updatePen(Color colorInput);

}
