package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.Arrays;

/**
 * 169. Majority Element Solved Easy
 *
 * <p>Given an array nums of size n, return the majority element.
 *
 * <p>The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that
 * the majority element always exists in the array.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [3,2,3] Output: 3 Example 2:
 *
 * <p>Input: nums = [2,2,1,1,1,2,2] Output: 2
 *
 * <p>Constraints:
 *
 * <p>n == nums.length 1 <= n <= 5 * 104 -109 <= nums[i] <= 109
 */
public class MajorityElement {
  public static void main(String[] args) {

    ExecutionMeasure.measureExecutionTime(
        "sorting O(n log(n))", () -> majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    ExecutionMeasure.measureExecutionTime(
        "moore voting algorithm O(n)", () -> mooreVoting(new int[] {2, 2, 1, 1, 1, 2, 2}));
  }

  private static int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  static int mooreVoting(int[] nums) {
    int vote = 0;
    int max = Integer.MAX_VALUE;
    for (int n : nums) {
      if (vote == 0) {
        max = n;
      }
      if (n == max) {
        vote++;
      } else {
        vote--;
      }
    }
    return max;
  }
}
