/**
 * This interface defines the methods for the properties of an object on a Canvas / Screen in the
 * View. It contains all the methods that are needed on order to locate and position any type of
 * object on the Canvas. For objects like turtles, it also declares it rotation by storing a degree
 * value.
 *
 * @author Haris Adnan
 */

public interface Object {

  /**
   * Get function to return the x coordinate of the object
   *
   * @return x-coordinate of object
   */
  public double getX();

  /**
   * Get function to return the y coordinate of the object
   *
   * @return y-coordinate of object
   */
  public double getY();

  /**
   * Set Function to set the x coordinate of the object
   *
   * @param x: x coordinate to be set
   */
  public void setX(double x);

  /**
   * Set Function to set the y coordinate of the object
   *
   * @param y : y coordinate to be set
   */
  public void setY(double y);

  /**
   * Get function to obtain the degree property of the object
   *
   * @return degree: current degree value
   */
  public double getDegrees();

  /**
   * Sets the degree value for the object
   *
   * @param degrees: degree value to be set
   */
  public void setDegrees(double degrees);

  /**
   * Sets the color of the pen so that this is the color that the pen writes with
   *
   * @param Color : Color that is used to write
   */
  public void setColor(Paint Color);

  /**
   * Changes th e location of the object in the back end to the new location given
   * @param newPoint
   */
  public void changeObjectLocation(Point newPoint)

}