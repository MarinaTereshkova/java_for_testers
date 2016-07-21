package ru.sfwt.mt.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("word");
    hello("user");
    hello("Marina");

    Square s = new Square(5);
    System.out.println("S квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 6);
    System.out.println("S прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hell, " + somebody + "!");
  }
}