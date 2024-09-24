package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

import java.util.HashSet;
import java.util.Set;

public class ExtraCharsInString {

    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime(() -> Solution.minExtraChar("leetscode", new String[]{"leet","code","leetcode"} ));
    }
    private static class Solution {
        public static int minExtraChar(String s, String[] dictionary) {
            Set<String> dict = new HashSet<>();
            for (String w : dictionary) {
                dict.add(w);
            }

            int n = s.length();
            int[] dp = new int[n + 1]; // dp[i] means the minimum extra characters for substring s[0:i]

            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1] + 1; // Assume the worst case where s[i-1] is an extra character
                for (int j = 0; j < i; j++) {
                    String currStr = s.substring(j, i);
                    if (dict.contains(currStr)) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
            }

            return dp[n];
        }
    }
}
