package slogo.View.Observer;

// internal view observer

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;


/**
 * Purpose: The purpose of this class is that it serves as an observer for the front end classes
 * informational panes that the users can use to change the background color of the canvas and pen
 * color
 * <p>
 * Assumption: We assume that the classes being watched will call the observer class and add the
 * subscribers correctly
 * <p>
 * Dependencies: This class depends on the observers that call its methods and the listener in order
 * to successfully notify the subscribers
 * <p>
 * Example: When the colorpicker is changed in the front end, it notifies the observer and its
 * subscribers to update the listeners.
 * <p>
 * Misc: Kinda scuffed observer as I ended up having to pass what subscriber was supposed to be
 * added into the class itself, which meant I could've just straight up updated it there. I was
 * definitely confused here
 *
 * @author: Eric Xie
 */

public class ViewPublisher {

  private Color colorInput;
  private List<ViewListener> listeners = new ArrayList<>();

  /**
   * Purpose: Adds a listener that the observer should notify
   * <p>
   * Assumption: Assume that the observer added is meant to be added
   * <p>
   * Dependencies: This class depends on the observers that call its methods and the listener in
   * order to successfully notify the subscribers
   * <p>
   * Example: Used when adding subscribers
   * <p>
   *
   * @param listen ViewListener interface class that we want to notify
   */

  public void addObserver(ViewListener listen) {
    this.listeners.add(listen);
  }

  /**
   * Purpose: Called by the object being observed to update the color of the canvas
   * <p>
   * Assumption: Assume that the observer added is meant to be added
   * <p>
   * Dependencies: This class depends on the observers that call its methods and the listener in
   * order to successfully notify the subscribers
   * <p>
   * Example: Used when notifying canvas after the ColorPicker button event handler detects a new
   * color has been selected
   * <p>
   *
   * @param color Color that we want the background to be
   */

  public void updateColor(Color color) {
    this.colorInput = color;
    for (ViewListener listenerObj : this.listeners) {
      listenerObj.updateCanvas(this.colorInput);
    }
  }


  /**
   * Purpose: Called by the object being observed to update the color of the pen
   * <p>
   * Assumption: Assume that the observer added is meant to be added
   * <p>
   * Dependencies: This class depends on the observers that call its methods and the listener in
   * order to successfully notify the subscribers
   * <p>
   * Example: Used when notifying Animation after the ColorPicker button event handler detects a new
   * color has been selected
   * <p>
   *
   * @param color Color that we want the background to be
   */

  public void updatePen(Color color) {
    this.colorInput = color;
    for (ViewListener listenerObj : this.listeners) {
      listenerObj.updatePen(this.colorInput);
    }
  }


}
