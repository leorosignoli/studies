package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashMap;
import java.util.Map;

/**
 * ## 1. Two Sum
 *
 * <p>Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>You can return the answer in any order.
 */
public class TwoSum {

  public static void main(String[] args) {

    int[] nums = {2, 7, 11, 15, 12, 14, 4, 25, 1};
    int target = 9;
    ExecutionMeasure.measureExecutionTime(() -> twoSum(nums, target));
    ExecutionMeasure.measureExecutionTime(() -> twoSum2(nums, target));
  }

  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {

      for (int j = 0; j < nums.length; j++) {

        if ((nums[i] + nums[j]) == target) return new int[] {i, j};
      }
    }
    return new int[0]; // no solution
  }

  public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }
    // In case there is no solution, we'll just return null
    return null;
  }
}
