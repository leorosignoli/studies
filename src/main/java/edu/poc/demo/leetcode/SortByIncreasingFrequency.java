package edu.poc.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * # 1636. Sort Array by Increasing Frequency Given an array of integers nums, sort the array in
 * increasing order based on the frequency of the values. If multiple values have the same
 * frequency, sort them in decreasing order.
 *
 * <p>Return the sorted array.
 */
public class SortByIncreasingFrequency {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(frequencySort(new int[] {1, 1, 2, 2, 2, 3, 4, 4})));
  }

  static int[] frequencySort(int[] nums) {
    // Create the frequency map
    Map<Integer, Integer> occurrencesMap = getOccurrencesMap(nums);

    // Convert int[] to Integer[] for sorting with custom comparator
    Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);

    // Sort the array based on the custom comparator
    Arrays.sort(
        numsObj,
        (a, b) -> {
          int freqCompare = Integer.compare(occurrencesMap.get(a), occurrencesMap.get(b));
          if (freqCompare != 0) {
            return freqCompare;
          }
          return Integer.compare(b, a); // Descending order if frequencies are equal
        });

    // Convert back to int[] and return
    return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();
  }

  static Map<Integer, Integer> getOccurrencesMap(int[] arr) {
    Map<Integer, Integer> vals = new HashMap<>();
    for (int number : arr) {
      vals.merge(number, 1, Integer::sum);
    }
    return vals;
  }
}
