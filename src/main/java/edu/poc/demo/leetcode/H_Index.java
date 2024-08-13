package edu.poc.demo.leetcode;

import java.util.Arrays;

/**
 * 274. H-Index Solved Medium
 *
 * <p>Hint Given an array of integers citations where citations[i] is the number of citations a
 * researcher received for their ith paper, return the researcher's h-index.
 *
 * <p>According to the definition of h-index on Wikipedia: The h-index is defined as the maximum
 * value of h such that the given researcher has published at least h papers that have each been
 * cited at least h times.
 *
 * <p>Example 1:
 *
 * <p>Input: citations = [3,0,6,1,5] Output: 3 Explanation: [3,0,6,1,5] means the researcher has 5
 * papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the
 * researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3
 * citations each, their h-index is 3. Example 2:
 *
 * <p>Input: citations = [1,3,1] Output: 1
 */
public class H_Index {
  public static void main(String[] args) {
    System.out.println(new H_Index().hIndex(new int[] {3, 0, 6, 1, 5})); // 3
  }

  public int hIndex(int[] citations) {
    Arrays.sort(citations);

    for (int i = 0; i < citations.length; i++) {
      int h = citations.length - i; // Number of papers with at least citations[i] citations
      if (citations[i] >= h) {
        return h; // Found the h-index
      }
    }
    return 0;
  }
}
