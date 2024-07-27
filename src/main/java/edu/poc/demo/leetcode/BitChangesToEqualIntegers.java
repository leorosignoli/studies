package edu.poc.demo.leetcode;

/**
 * 3226. Number of Bit Changes to Make Two Integers Equal
 *
 * <p>You are given two positive integers n and k.
 *
 * <p>You can choose any bit in the binary representation of n that is equal to 1 and change it to
 * 0.
 *
 * <p>Return the number of changes needed to make n equal to k. If it is impossible, return -1.
 */
public class BitChangesToEqualIntegers {

  public static void main(String[] args) {
    BitChangesToEqualIntegers bitChangesToEqualIntegers = new BitChangesToEqualIntegers();
    System.out.println(bitChangesToEqualIntegers.minChanges(13, 401));
  }

  public int minChanges(int n, int k) {

    if (n == k) return 0;

    int counter = 0;

    while (n > 0) {

      int nRem = n % 2;
      int kRem = k % 2;

      if ((nRem == 1) && (kRem == 0)) counter++;
      else if ((nRem == 0) && (kRem == 1)) return -1;

      n = n / 2;
      k = k / 2;
    }

    return counter;
  }
}
