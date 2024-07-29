package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.Random;

/**
 * 1395. Count Number of Teams
 *
 * <p>There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 *
 * <p>You have to form a team of 3 soldiers amongst them under the following rules:
 *
 * <p>Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]). A team
 * is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0
 * <= i < j < k < n). Return the number of teams you can form given the conditions. (soldiers can be
 * part of multiple teams).
 *
 * <p>Example 1:
 *
 * <p>Input: rating = [2,5,3,4,1] Output: 3 Explanation: We can form three teams given the
 * conditions. (2,3,4), (5,4,1), (5,3,1). Example 2:
 *
 * <p>Input: rating = [2,1,3] Output: 0 Explanation: We can't form any team given the conditions.
 * Example 3:
 *
 * <p>Input: rating = [1,2,3,4] Output: 4
 */
public class CountNumberOfTeams {

  public static void main(String[] args) {
    int[] randomSequence = new Random().ints(1, 100).distinct().limit(70).toArray();

    ExecutionMeasure.measureExecutionTime("brute force", () -> numTeams(randomSequence));
    ExecutionMeasure.measureExecutionTime("optimized", () -> numTeamsOptimized(randomSequence));
  }

  /*
     Brute force.
     Takes O(nˆ3) time complexity, not good
  */
  private static int numTeams(int[] rating) {
    int total = 0;
    for (int left = 0; left < rating.length - 2; left++) {

      int first = rating[left];

      for (int middle = left + 1; middle < rating.length - 1; middle++) {

        int second = rating[middle];

        for (int right = middle + 1; right < rating.length; right++) {

          int third = rating[right];
          if (isSequence(first, second, third)) total++;
        }
      }
    }
    return total;
  }

  private static boolean isSequence(int first, int second, int third) {

    if (first < second) {
      return second < third;
    } else if (first > second) {
      return second > third;
    } else {
      return false;
    }
  }

  /** Optimized solution O(nˆ2) */
  private static int numTeamsOptimized(int[] rating) {

    int total = 0;
    for (int first = 0; first < rating.length - 1; first++) {

      int smallerLeft = 0;
      int biggerLeft = 0;
      for (int second = 0; second < first; second++) {

        if (rating[second] < rating[first]) {
          smallerLeft++;
        }
        if (rating[second] > rating[first]) {
          biggerLeft++;
        }
      }

      int smallerRight = 0;
      int biggerRight = 0;
      for (int second = rating.length - 1; second > first; second--) {

        if (rating[second] < rating[first]) {
          smallerRight++;
        }
        if (rating[second] > rating[first]) {
          biggerRight++;
        }
      }
      total += smallerLeft * biggerRight + biggerLeft * smallerRight;
    }

    return total;
  }
}
