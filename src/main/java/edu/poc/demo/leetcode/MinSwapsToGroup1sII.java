package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class MinSwapsToGroup1sII {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[] {0, 1, 1, 1, 0, 0, 1, 1, 0}));
    ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[] {0, 1, 0, 1, 1, 0, 0}));
    ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[] {1, 1, 0, 0, 1})); // 1
  }

  public static int minSwaps(int[] nums) {

    int min = Integer.MAX_VALUE;
    int ones = 0;
    for (int n : nums) if (n == 1) ones++;
    for (int i = 0; i < nums.length; i++) {
      int zeros = 0;
      int r = i + ones;
      int l = i;

      while (l < r) {
        if (nums[l % nums.length] == 0) {
          zeros++;
        }
        l++;
      }
      min = Math.min(zeros, min);
    }
    return min;
  }
}
