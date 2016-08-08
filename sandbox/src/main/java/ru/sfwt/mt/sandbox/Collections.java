package ru.sfwt.mt.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {

    //--------1й способ задания массивов
  //  String[] langs = new String[4];
  //  langs[0] = "Java";
  //  langs[1] = "C#";
  //  langs[2] = "Python";
  //  langs[3] = "PHP";

    //--------2й способ задания массивов - короткий
    String[] langs = {"Java", "C#", "Python", "PHP"};

      //--------цикл для массива 1й способ
    //  for (int i = 0; i < langs.length; i++) {
    //    System.out.println("Я хочу выучить " + langs[i]);
    //  }
    //--------цикл для массива
    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

    //--------Создание списка
    //  List<String> languages = new ArrayList<String>();
    //  languages.add("Java");
    //  languages.add("C#");
    //  languages.add("Python");

    //--------преобразование массива в список
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    //--------цикл для списков
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    //--------цикл для списков-массивов - итерации по эелемнтам списка
    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
    //--------задание списка без указания типа
    List withoutType = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : withoutType) {
      System.out.println("Я хочу выучить " + l);
    }

  }
}
