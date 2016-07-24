package ru.sfwt.mt.sandbox;

public class PointCalculate {
  public static void main(String[] args) {
    Point point1 = new Point(1, 2);
  /*  point1.x = 1;
    point1.y = 2;
  */
    Point point2 = new Point();
    point2.x = 4;
    point2.y = 5;

    System.out.println("Distance between points " + point1.distance(point2));
  }
}
