package ru.sfwt.mt.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("word");
    hello("user");
    hello("Marina");

    double len = 5;
    System.out.println("S квадрата со стороной " + len + " = " + area(len));

    double a = 5;
    double b = 6;
    System.out.println("S прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
  }

  public static void hello(String somebody) {
    System.out.println("Hell, " + somebody + "!");
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}