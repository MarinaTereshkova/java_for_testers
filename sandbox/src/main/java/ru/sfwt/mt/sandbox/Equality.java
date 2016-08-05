package ru.sfwt.mt.sandbox;

public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    //the first situation
    //String s2 = s1;

    //the second situation
    //String s2 = new String(s1);

    //the third situation
    String s2 = "firefox";
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
