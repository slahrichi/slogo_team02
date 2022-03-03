package slogo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PointTest {
  double Xval = 50.0;
  double Yval =50.0 ;
  private Point myPoint = new Point(Xval, Yval);
  @Test
  void getPointXTest(){
    assertEquals(50.0, myPoint.getPointX());
  }
  @Test
  void getPointYTest(){
    assertEquals(50.0, myPoint.getPointY());
  }


}
