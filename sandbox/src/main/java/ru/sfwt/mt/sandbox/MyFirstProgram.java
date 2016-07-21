package ru.sfwt.mt.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("word");
    hello("user");
    hello("Marina");

    Square s = new Square(5);
    System.out.println("S квадрата со стороной " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(5,6);
    System.out.println("S прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
  }

  public static void hello(String somebody) {
    System.out.println("Hell, " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}