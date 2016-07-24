package ru.sfwt.mt.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("word");
  /*  hello("user");
    hello("Marina"); */


  /*Area of square */
    Square s = new Square(5);
    System.out.println("S квадрата со стороной " + s.l + " = " + s.area());

  /*Area of rectangle*/
    Rectangle r = new Rectangle(5, 6);
    System.out.println("S прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point point1 = new Point();
    point1.x = 1;
    point1.y = 2;

    Point point2 = new Point();
    point2.x = 4;
    point2.y = 5;

    System.out.println("Distance between points " + distance(point1, point2));
  }

  public static void hello(String somebody) {
    System.out.println("Hell, " + somebody + "!");
  }

  /*Distance between two points*/
  public static double distance(Point p1, Point p2) {
    double d = Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p1.y),2);
    double dist = Math.sqrt(d);
    return dist;


  }
}