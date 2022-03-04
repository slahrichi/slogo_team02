package slogo.Model;

/**
 * Point class defining a point on the screen
 * @author Haris Adnan
 */
public class Point {
  private double Xval;
  private double Yval;

  public Point(double x, double y){
    Xval = x;
    Yval = y;
  }

  /**
   * gets the x coordinate of a point
   * @return x coor of point
   */
  public double getPointX() {
    return Xval;
  }

  /**
   * gets the y coordinate of a point
   * @return y coordinate of a point
   */
  public double getPointY() {
    return Yval;
  }

  /**
   * finds out the distance between two points
   * @param a : Point number 1
   * @param b : Point number 2
   * @return : distance between point 1 and 2
   */
//  public double distanceBetweenPoints(Point a, Point b){
//    double deltaX = Math.abs(a.getPointX() - b.getPointX());
//    double deltaY = Math.abs(a.getPointY() - b.getPointY());
//    return Math.pow(Math.pow(deltaX, 2.0) + Math.pow(deltaY, 2.0), 0.5);
//  }

}
