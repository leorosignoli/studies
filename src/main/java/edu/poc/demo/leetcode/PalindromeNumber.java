package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

/**
 * 9. Palindrome Number
 *
 * <p>Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> new PalindromeNumber().isPalindrome(-1));
    ExecutionMeasure.measureExecutionTime(
        () -> new PalindromeNumber().isPalindrome(RandomGenerator.getDefault().nextInt(100000)));
  }

  private boolean isPalindrome(int x) {
    if (x < 0) return false;
    if (x / 10 == 0) return true;

    List<Integer> dissected = new ArrayList<>();
    while (x != 0) {
      dissected.add(x % 10);
      x /= 10;
    }

    for (int i = 0; i < dissected.size() / 2; i++) {

      if ((dissected.get(i) - dissected.get(dissected.size() - 1 - i)) != 0) {
        return false;
      }
    }
    return true;
  }
}
