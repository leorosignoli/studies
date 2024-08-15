package edu.poc.demo.leetcode;

/**
 * 1071. Greatest Common Divisor of Strings Solved Easy
 *
 * <p>Topics Companies
 *
 * <p>Hint For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 * (i.e., t is concatenated with itself one or more times).
 *
 * <p>Given two strings str1 and str2, return the largest string x such that x divides both str1 and
 * str2.
 *
 * <p>Example 1:
 *
 * <p>Input: str1 = "ABCABC", str2 = "ABC" Output: "ABC" Example 2:
 *
 * <p>Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB" Example 3:
 *
 * <p>Input: str1 = "LEET", str2 = "CODE" Output: ""
 */
public class GreatestCommonDenominatorOfStrings {

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  private String gcdOfStrings(String str1, String str2) {
    // Check if they have a non-zero GCD string
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }

    // Find the GCD of the lengths of the two strings
    int gcdLength = gcd(str1.length(), str2.length());

    // Return the substring of str1 from 0 to gcdLength
    return str1.substring(0, gcdLength);
  }
}
