package ru.sfwt.mt.sandbox;

public class Primes {
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


// public static boolean isPrimeWhile(int n) {
//   int i = 2;
//   while (i < n) {
//     if (n % i == 0) {
//       return false;
//     }
//   i++;
//   }
//   return true;
// }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
    }
    return i == n;
  }


  //type of params 'n' and 'i' is long
  public static boolean isPrime(long n) {
    for (long i = 2; i < n; i++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    for (int i = 2; i < n / 2; i++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeFastSqrt(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
