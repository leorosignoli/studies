package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.Arrays;

public class RangeSumOfSortedSubArrays {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 5));
  }

  public static int rangeSum(int[] nums, int n, int left, int right) {

    long[] res = new long[n * (n + 1) / 2];
    int resPointer = 0;
    for (int l = 0; l < n; l++) {
      int r = l;
      res[resPointer++] = nums[r++];
      while (r < n) {
        res[resPointer++] = nums[l] + nums[r++];
      }
    }
    Arrays.sort(res);

    long sum = 0;
    for (int j = left - 1; j < right; j++) {
      sum += res[j];
    }
    return (int) sum;
  }
}
