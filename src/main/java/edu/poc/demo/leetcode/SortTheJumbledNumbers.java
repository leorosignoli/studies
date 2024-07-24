package edu.poc.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 2191. Sort the Jumbled Numbers
 *
 * <p>You are given a 0-indexed integer array mapping which represents the mapping rule of a
 * shuffled decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.
 *
 * <p>The mapped value of an integer is the new integer obtained by replacing each occurrence of
 * digit i in the integer with mapping[i] for all 0 <= i <= 9.
 *
 * <p>You are also given another integer array nums. Return the array nums sorted in non-decreasing
 * order based on the mapped values of its elements.
 *
 * <p>Notes:
 *
 * <p>Elements with the same mapped values should appear in the same relative order as in the input.
 * The elements of nums should only be sorted based on their mapped values and not be replaced by
 * them.
 */
public class SortTheJumbledNumbers {

  public static void main(String[] args) {
    SortTheJumbledNumbers sortTheJumbledNumbers = new SortTheJumbledNumbers();
    int[] mapping = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int[] nums = {0, 1, 2, 3, 0, 5, 6, 7, 8, 9};
    int[] sortedJumbled = sortTheJumbledNumbers.sortJumbled(mapping, nums);
    for (int i = 0; i < sortedJumbled.length; i++) {
      System.out.println(sortedJumbled[i]);
    }
  }

  public int[] sortJumbled(int[] mapping, int[] nums) {

    int[] jumbledNumbers = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {

      List<Integer> separatedNumber = separateNumbers(nums[i]);

      jumbledNumbers[i] = (mapNumber(mapping, separatedNumber));
    }

    reorderArrays(jumbledNumbers, nums);
    return nums;
  }

  public List<Integer> separateNumbers(int n) {
    List<Integer> res = new ArrayList<>();
    if (n == 0) {
      res.add(0);
      return res;
    }

    while (n != 0) {
      res.add(n % 10);
      n /= 10;
    }
    Collections.reverse(res);
    return res;
  }

  public int mapNumber(int[] mappingRules, List<Integer> sepNum) {

    int jumbledNumber = 0;

    for (int j = 0; j < sepNum.size(); j++) {

      jumbledNumber += (int) (mappingRules[sepNum.get(j)] * Math.pow(10, (sepNum.size() - 1 - j)));
    }

    return jumbledNumber;
  }

  public void reorderArrays(int[] jumbledNumbers, int[] nums) {
    int n = jumbledNumbers.length;
    int[][] combined = new int[n][2];

    for (int i = 0; i < n; i++) {
      combined[i][0] = jumbledNumbers[i];
      combined[i][1] = nums[i];
    }

    Arrays.sort(combined, Comparator.comparingInt(a -> a[0]));

    for (int i = 0; i < n; i++) {
      nums[i] = combined[i][1];
    }
  }
}
