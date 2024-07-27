package edu.poc.demo.leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2976. Minimum Cost to Convert String I
 *
 * <p>You are given two 0-indexed strings source and target, both of length n and consisting of
 * lowercase English letters. You are also given two 0-indexed character arrays original and
 * changed, and an integer array cost, where cost[i] represents the cost of changing the character
 * original[i] to the character changed[i].
 *
 * <p>You start with the string source. In one operation, you can pick a character x from the string
 * and change it to the character y at a cost of z if there exists any index j such that cost[j] ==
 * z, original[j] == x, and changed[j] == y.
 *
 * <p>Return the minimum cost to convert the string source to the string target using any number of
 * operations. If it is impossible to convert source to target, return -1.
 *
 * <p>Note that there may exist indices i, j such that original[j] == original[i] and changed[j] ==
 * changed[i].
 *
 * <p>Example 1:
 *
 * <p>Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed =
 * ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20] Output: 28 Explanation: To convert the string
 * "abcd" to string "acbe": - Change value at index 1 from 'b' to 'c' at a cost of 5. - Change value
 * at index 2 from 'c' to 'e' at a cost of 1. - Change value at index 2 from 'e' to 'b' at a cost of
 * 2. - Change value at index 3 from 'd' to 'e' at a cost of 20. The total cost incurred is 5 + 1 +
 * 2 + 20 = 28. It can be shown that this is the minimum possible cost.
 */
public class MinimumCostToConvertString {

  public static void main(String[] args) {
    MinimumCostToConvertString minimumCostToConvertString = new MinimumCostToConvertString();
    System.out.println(
        minimumCostToConvertString.minimumCost(
            "abcd",
            "acbe",
            new char[] {'a', 'b', 'c', 'c', 'e', 'd'},
            new char[] {'b', 'c', 'b', 'e', 'b', 'e'},
            new int[] {2, 5, 5, 1, 2, 20}));
  }

  public long minimumCost(
      String source, String target, char[] original, char[] changed, int[] cost) {

    Map<Character, Map<Character, Integer>> adjacentMap = fillAdjList(original, changed, cost);

    long[][] minConversionCosts = new long[26][26];
    for (char c = 'a'; c <= 'z'; c++) {
      minConversionCosts[c - 'a'] = fillMatrix(c, adjacentMap);
    }

    long minConversionCost = 0;
    for (int i = 0; i < source.length(); i++) {
      long costForChar = minConversionCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
      if (costForChar == Long.MAX_VALUE) {
        return -1;
      }
      minConversionCost += costForChar;
    }

    return minConversionCost;
  }

  private long[] fillMatrix(
      char startingChar, Map<Character, Map<Character, Integer>> adjacentMap) {
    long[] minCosts = new long[26];
    Arrays.fill(minCosts, Long.MAX_VALUE);
    minCosts[startingChar - 'a'] = 0;

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingLong(arr -> arr[1]));
    queue.add(new int[] {startingChar - 'a', 0});

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentCharIndex = current[0];
      long currentCost = current[1];

      char currentChar = (char) (currentCharIndex + 'a');
      if (!adjacentMap.containsKey(currentChar)) {
        continue;
      }

      for (Map.Entry<Character, Integer> entry : adjacentMap.get(currentChar).entrySet()) {
        char neighbor = entry.getKey();
        int edgeCost = entry.getValue();
        long newCost = currentCost + edgeCost;

        if (newCost < minCosts[neighbor - 'a']) {
          minCosts[neighbor - 'a'] = newCost;
          queue.add(new int[] {neighbor - 'a', (int) newCost});
        }
      }
    }

    return minCosts;
  }

  /**
   * adds a relation from each path to destination with the structure as the following example.
   *
   * <p>{ a:[(b,3), (c,2)], b: [(c,1), (a,3)], c: [(b,1), (a,2)] }
   */
  private static Map<Character, Map<Character, Integer>> fillAdjList(
      char[] original, char[] changed, int[] cost) {
    Map<Character, Map<Character, Integer>> adjacentMap = new HashMap<>();

    for (int i = 0; i < original.length; i++) {
      adjacentMap
          .computeIfAbsent(original[i], k -> new HashMap<>())
          .put(
              changed[i],
              Math.min(
                  adjacentMap.get(original[i]).getOrDefault(changed[i], Integer.MAX_VALUE),
                  cost[i]));
    }
    return adjacentMap;
  }
}
