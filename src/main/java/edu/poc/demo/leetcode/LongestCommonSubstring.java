package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime( () -> new Solution().longestCommonSubsequence("lifel", "llliii"));
    }
    private static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            // Create a 2D array to store lengths of longest common subsequence.
            int[][] dp = new int[m + 1][n + 1];

            // Build the dp array from bottom up.
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // The value at dp[m][n] contains the length of LCS for text1[0..m-1] and text2[0..n-1].
            return dp[m][n];
        }
    }

}
