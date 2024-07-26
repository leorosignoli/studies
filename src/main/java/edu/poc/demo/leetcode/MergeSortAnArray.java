package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.Arrays;

/**
 * 912. Sort an Array
 *
 * <p>Given an array of integers nums, sort the array in ascending order and return it.
 *
 * <p>You must solve the problem without using any built-in functions in O(nlog(n)) time complexity
 * and with the smallest space complexity possible.
 */
public class MergeSortAnArray {

  public static void main(String[] args) {
    MergeSortAnArray mergeSortAnArray = new MergeSortAnArray();
    int[] arr = {3, 2, 1, 14, 4, 5, 7, 6, 8, 9, 0, 10, 13};
    ExecutionMeasure.measureExecutionTime(() -> mergeSortAnArray.mergeSort(arr));
  }

  private int[] mergeSort(int[] arr) {

    if (arr.length <= 1) return arr;

    int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
    int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
  }

  private int[] merge(int[] left, int[] right) {

    int[] res = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;

    while ((i < left.length) && (j < right.length)) {

      if (left[i] <= right[j]) {
        res[k++] = left[i++];
      } else {
        res[k++] = right[j++];
      }
    }
    while (i < left.length) {
      res[k++] = left[i++];
    }
    while (j < right.length) {
      res[k++] = right[j++];
    }
    return res;
  }
}
