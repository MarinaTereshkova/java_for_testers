package ru.sfwt.mt.sandbox;

public class PointCalculate {
  public static void main(String[] args) {
    Point point1 = new Point();
    point1.x = 1;
    point1.y = 2;

    Point point2 = new Point();
    point2.x = 4;
    point2.y = 5;

    System.out.println("Distance between points " + distance(point1, point2));
  }

  /*Distance between two points*/
  public static double distance(Point p1, Point p2) {
    double delta = Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2);
    return Math.round(Math.sqrt(delta)*100)/100.0;
  }
}
