/**
 * This interface determines how the Pen draws as the turtle moves. It consists of the methods that
 * will allow the Pen to draw on a canvas / screen of the View.
 *
 * @author Haris Adnan
 */
public interface Pen {

  /**
   * This method makes the Pen draw a section of the figure at the location it is located at. This
   * method will be called when the pen is down so that it leaves a small mark on that location on
   * the canvas.
   */
  public void write();

  /**
   * Takes the pen "off" the canvas so that when the pen moves, it does not leave behind a mark on
   * the canvas.
   */
  public void penUp();

  /**
   * Puts the pen on the canvas so that the pen is now able to write on the canvas
   */
  public void penDown();
}