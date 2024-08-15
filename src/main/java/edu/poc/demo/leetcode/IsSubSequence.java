package edu.poc.demo.leetcode;

/**
 * 392. Is Subsequence Solved Easy
 *
 * <p>Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * <p>A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * <p>Example 1:
 *
 * <p>Input: s = "abc", t = "ahbgdc" Output: true Example 2:
 *
 * <p>Input: s = "axc", t = "ahbgdc" Output: false
 *
 * <p>Constraints:
 *
 * <p>0 <= s.length <= 100 0 <= t.length <= 104 s and t consist only of lowercase English letters.
 *
 * <p>Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you
 * want to check one by one to see if t has its subsequence. In this scenario, how would you change
 * your code?
 */
public class IsSubSequence {
  private boolean isSubsequence(String s, String t) {

    if (s.isEmpty()) {
      return true;
    }
    if (t.isEmpty()) {
      return false;
    }

    int sPointer = 0;
    for (int i = 0; i < t.length(); i++) {
      if (sPointer < s.length() && t.charAt(i) == s.charAt(sPointer)) {
        sPointer++;
      }
    }
    System.out.println(sPointer);
    return sPointer >= s.length();
  }
}
