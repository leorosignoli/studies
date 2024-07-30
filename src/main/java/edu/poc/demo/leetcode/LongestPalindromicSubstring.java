package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    ExecutionMeasure.measureExecutionTime(
        () -> longestPalindromicSubstring.longestPalindrome("bo5jgw;5sdaewrfiewhujof"));
    ExecutionMeasure.measureExecutionTime(() -> longestPalindrome2("cbbd"));
    ExecutionMeasure.measureExecutionTime(() -> longestPalindrome2("ccc"));
    ExecutionMeasure.measureExecutionTime(() -> longestPalindrome2("sdaabbaadds"));
    ExecutionMeasure.measureExecutionTime(() -> longestPalindrome2("abb"));
  }

  public static String longestPalindrome2(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    String longest = "";

    for (int i = 0; i < s.length(); i++) {
      // Check for odd-length palindromes centered at i
      String oddPalindrome = expandAroundCenter(s, i, i);
      if (oddPalindrome.length() > longest.length()) {
        longest = oddPalindrome;
      }

      // Check for even-length palindromes centered between i and i+1
      String evenPalindrome = expandAroundCenter(s, i, i + 1);
      if (evenPalindrome.length() > longest.length()) {
        longest = evenPalindrome;
      }
    }

    return longest;
  }

  private static String expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }

  private static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {

      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    }
    return true;
  }

  private static String getBiggerString(String str1, String str2) {
    return str1.length() > str2.length() ? str1 : str2;
  }

  public String longestPalindrome(String s) {

    if (s.length() < 2) {
      return s;
    }

    String biggestStr = String.valueOf(s.charAt(0));

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      String substring = s.substring(i, s.lastIndexOf(currentChar) + 1);

      while (substring.indexOf(currentChar) != substring.lastIndexOf(currentChar)) {
        if (isPalindrome(substring)) {
          biggestStr = getBiggerString(biggestStr, substring);
        }
        substring =
            substring.substring(
                0, substring.lastIndexOf(currentChar, substring.lastIndexOf(currentChar) - 1) + 1);
      }
    }

    return biggestStr;
  }
}
