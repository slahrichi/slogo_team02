package slogo.View.APIs;

/**
 * ViewAPI for the front end to connect with the controller in sending file contents after typing in
 * the editor or the shell input boxes. It also offers a clearHistory option for the controller to
 * use whenever we reset the program.
 * <p>
 * Assumptions: Used correctly by the controller to communicate with the front-end with things like
 * the command history panel and the animation handling of the turtle image
 * <p>
 * Dependencies: This interface is implemented by the slogoGUI class and called on by the Controller
 * class for communication
 * <p>
 * Example: One example of this being used is when the parsed commands are being taken by the
 * controller; for each command in the list, the controller calls the view/front-end to create the
 * corresponding animation for the turtle using the notifyAnimation() method
 * <p>
 * This API crosses between interface and somewhat of a listener for the slogoGUI, allowing the
 * controller to notify it of changes
 *
 * @author Mike Keohane and Eric Xie
 */

public interface ObserverViewInterface {

  /**
   * Used by the controller to notify the frontend's command history panel that something has
   * changed and to update itself
   */

  void notifyHistory();

  /**
   * Used by the controller to notify the front end to check the TurtleRecord and create an
   * animation based off the change in the turtle's position, angle, etc..
   */

  void notifyAnimation();

  /**
   * Used by the controller to notify that the entire list of commands has been ran through, and to
   * play the entire sequential transition, containing the different animations that were in the
   * list
   */

  void animationComplete();
}
