package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * ## 14. Longest Common Prefix
 *
 * <p>Write a function to find the longest common prefix string amongst an array of strings.
 *
 * <p>If there is no common prefix, return an empty string "".
 *
 * <p>Example 1:
 *
 * <p>Input: strs = ["flower","flow","flight"] Output: "fl" Example 2:
 *
 * <p>Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no common prefix among
 * the input strings.
 */
public class LongestCommonPrefix {
  public static void main(String[] args) {

    ExecutionMeasure.measureExecutionTime(
        () -> longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
  }

  private static String longestCommonPrefix(String[] strs) {


    StringBuilder max = new StringBuilder();
    String firstStr = strs[0];
    for (int j = 0; j < strs[0].length(); j++) {
      for (String str : strs) {
        if ( j == strs[j].length() || firstStr.charAt(j) != str.charAt(j)) {
          return max.toString();
        }
      }
      max.append(firstStr.charAt(j));
    }

    return max.toString();
  }
}
