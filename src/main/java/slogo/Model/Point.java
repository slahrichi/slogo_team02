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

}
