package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 1653. Minimum Deletions to Make String Balanced
 *
 * <p>You are given a string s consisting only of characters 'a' and 'b'
 *
 * <p>You can delete any number of characters in s to make s balanced. s is balanced if there is no
 * pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 *
 * <p>Return the minimum number of deletions needed to make s balanced.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "aababbab" Output: 2 Explanation: You can either: Delete the characters at
 * 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or Delete the characters at 0-indexed
 * positions 3 and 6 ("aababbab" -> "aabbbb"). Example 2:
 *
 * <p>Input: s = "bbaaaaabb" Output: 2 Explanation: The only solution is to delete the first two
 * characters.
 */
public class MinDeletionsToBalanceString {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> minimumDeletions("aababbab"));
  }

  private static int minimumDeletions(String s) {

    int n = s.length();
    int[] dp = new int[n + 1];
    int bCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'b') {
        dp[i + 1] = dp[i];
        bCount++;
      } else dp[i + 1] = Math.min(dp[i] + 1, bCount);
    }
    return dp[n];
  }
}
