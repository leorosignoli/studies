package edu.poc.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II Solved Medium
 *
 * <p>Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sum to target.
 *
 * <p>Each number in candidates may only be used once in the combination.
 *
 * <p>Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates, target, 0, new ArrayList<>(), 0, res);
    return res;
  }

  private void dfs(
      int[] candidates,
      int target,
      int start,
      List<Integer> cur,
      int total,
      List<List<Integer>> res) {
    if (total == target) {
      res.add(new ArrayList<>(cur));
      return;
    }

    if (total > target || start == candidates.length) {
      return;
    }

    // include candidates[start]
    cur.add(candidates[start]);
    dfs(candidates, target, start + 1, cur, total + candidates[start], res);
    cur.remove(cur.size() - 1);

    // skip candidates[start]
    while (start + 1 < candidates.length && candidates[start] == candidates[start + 1]) {
      start++;
    }
    dfs(candidates, target, start + 1, cur, total, res);
  }
}
