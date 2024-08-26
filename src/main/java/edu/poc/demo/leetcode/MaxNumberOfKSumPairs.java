package edu.poc.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

  public static void main(String[] args) {
    int[] nums = {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
    int k = 3;
    System.out.println(maxOperations(nums, k));
  }

  static int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int totalCount = 0;

    // Populate the map with counts of each number
    for (int n : nums) {
      map.merge(n, 1, Integer::sum);
    }

    for (int n : nums) {
      int missingN = k - n;

      if (map.get(n) > 0 && map.getOrDefault(missingN, 0) > 0) {
        if (n == missingN && map.get(n) < 2) {
          continue; // Skip if we don't have at least two of the same number
        }

        // Decrease the count for both numbers in the pair
        map.put(n, map.get(n) - 1);
        map.put(missingN, map.get(missingN) - 1);
        totalCount++;
      }
    }

    return totalCount;
  }
}
