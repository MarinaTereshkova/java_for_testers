package ru.sfwt.mt.sandbox;

/**
 * Created by marina.tereshkova on 24.07.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point() {};

  /*Distance between two points*/
  public double distance(Point dot) {
    double delta = Math.pow((dot.x - this.x), 2) + Math.pow((dot.y - this.y), 2);
    return Math.round(Math.sqrt(delta)*100)/100.0;
  }
}
