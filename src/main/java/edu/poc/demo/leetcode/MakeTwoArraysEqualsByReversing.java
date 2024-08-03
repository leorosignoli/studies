package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

import java.util.Arrays;

/**
 * 1460. Make Two Arrays Equal by Reversing Subarrays
 *
 * <p>You are given two integer arrays of equal length target and arr. In one step, you can select
 * any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.
 *
 * <p>Return true if you can make arr equal to target or false otherwise. Example 1:
 *
 * <p>Input: target = [1,2,3,4], arr = [2,4,1,3] Output: true Explanation: You can follow the next
 * steps to convert arr to target: 1- Reverse subarray [2,4,1], arr becomes [1,4,2,3] 2- Reverse
 * subarray [4,2], arr becomes [1,2,4,3] 3- Reverse subarray [4,3], arr becomes [1,2,3,4] There are
 * multiple ways to convert arr to target, this is not the only way to do so. Example 2:
 *
 * <p>Input: target = [7], arr = [7] Output: true Explanation: arr is equal to target without any
 * reverses. Example 3:
 *
 * <p>Input: target = [3,7,9], arr = [3,7,11] Output: false Explanation: arr does not have value 9
 * and it can never be converted to target.
 */
public class MakeTwoArraysEqualsByReversing {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> canBeEqual(new int[] {1, 2, 3, 4}, new int[] {2, 4, 1, 3}));
    ExecutionMeasure.measureExecutionTime("sorting approach", () -> sortingApproach(new int[] {1, 2, 3, 4}, new int[] {2, 4, 1, 3}));
  }

  private static boolean canBeEqual(int[] target, int[] arr) {

    int reversedIndex = 0;
    for (int j = 0; j < target.length; j++) {

      boolean hasVal = false;

      for (int i = j; i < arr.length; i++) {

        if (arr[i] == target[j]) {
          reverseIntSubArray(arr, reversedIndex, i);
          reversedIndex++;
          hasVal = true;
          break;
        }
      }

      if (!hasVal) {
        return false;
      }
    }

    return true;
  }

  private static void reverseIntSubArray(int[] arr, int start, int end) {

    while (start < end) {
      int temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
  }

  public static boolean sortingApproach(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    return Arrays.equals(target, arr);
  }
}
