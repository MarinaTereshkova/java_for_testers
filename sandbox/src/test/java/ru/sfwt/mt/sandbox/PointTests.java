package ru.sfwt.mt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testPointPlus() {
    Point point1 = new Point(1, 2);
    Point point2 = new Point(4, 5);
   // assert point1.distance(point2) == 4.24;
    Assert.assertEquals(point1.distance(point2), 4.24);
  }

  @Test
  public void testPointMinus() {
    Point point1 = new Point(-1, -2);
    Point point2 = new Point(-4, -5);
    // assert point1.distance(point2) == 4.24;
    Assert.assertEquals(point1.distance(point2), 4.24);
  }

  @Test
  public void testPointZero() {
    Point point1 = new Point(0, 0);
    Point point2 = new Point(0, 0);
    // assert point1.distance(point2) == 0.0;
    Assert.assertEquals(point1.distance(point2), 0.0);
  }

  @Test
  public void testPointCombination() {
    Point point1 = new Point(-4.5, 0);
    Point point2 = new Point(0, 8.3);
    // assert point1.distance(point2) == 0.0;
    Assert.assertEquals(point1.distance(point2), 9.44);
  }
}
