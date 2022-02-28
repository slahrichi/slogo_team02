package slogo.Model;

/**
 * @author Haris Adnan
 */
public class Point {
  private double Xval;
  private double Yval;

  public Point(double x, double y){
    Xval = x;
    Yval = y;
  }

  public double getPointX() {
    return Xval;
  }

  public double getPointY() {
    return Yval;
  }

  public double distanceBetweenPoints(Point a, Point b){
    double deltaX = Math.abs(a.getPointX() - b.getPointX());
    double deltaY = Math.abs(a.getPointY() - b.getPointY());
    return Math.pow(Math.pow(deltaX, 2.0) + Math.pow(deltaY, 2.0), 0.5);
  }

}
