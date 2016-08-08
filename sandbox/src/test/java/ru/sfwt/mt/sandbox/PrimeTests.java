package ru.sfwt.mt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
  @Test(enabled = false)
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testNonPrimes() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test(enabled = false)
  public void testPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test(enabled = false)
  public void testNonPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertFalse(Primes.isPrime(n - 2));
  }

  @Test(enabled = false)
  public void testPrimesFast() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimesFastSqrt() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
}
