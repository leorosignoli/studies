package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class Merge2SortedArrays {
  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3));
  }

  static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1; // Pointer for nums1
    int j = n - 1; // Pointer for nums2
    int k = m + n - 1; // Pointer for the merged array

    // Merge nums1 and nums2 starting from the end
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    // If there are remaining elements in nums2, copy them
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}
