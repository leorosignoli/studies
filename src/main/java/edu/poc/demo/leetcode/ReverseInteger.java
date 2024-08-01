package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 7. Reverse Integer
 *
 * <p>Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * <p>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * <p>Example 1:
 *
 * <p>Input: x = 123 Output: 321 Example 2:
 *
 * <p>Input: x = -123 Output: -321 Example 3:
 *
 * <p>Input: x = 120 Output: 21
 */
public class ReverseInteger {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> reverse(123));
  }

  private static int reverse(int x) {
    long reverseVal = 0;

    while (x != 0) {
      int digit = x % 10;
      reverseVal = reverseVal * 10 + digit;
      if (reverseVal > Integer.MAX_VALUE || reverseVal < Integer.MIN_VALUE) {
        return 0;
      }
      x /= 10;
    }

    return (int) reverseVal;
  }
}
