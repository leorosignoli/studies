package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class MedianOfSortedArrays {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 7}));
  }

  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    double firstMedian = nums1.length > 0 ? getArrMedian(nums1) : 0;
    double secondMedian = nums2.length > 0 ? getArrMedian(nums2) : 0;

    return nums1.length > 0 && nums2.length > 0
        ? (firstMedian + secondMedian) / 2
        : firstMedian + secondMedian;
  }

  static double getArrMedian(int[] arr) {

    int half = arr.length / 2;

    if (arr.length % 2 == 0) {
      return (double) (arr[half] + arr[half - 1]) / 2;
    } else {
      return arr[half];
    }
  }
}
