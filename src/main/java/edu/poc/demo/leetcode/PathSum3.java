package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import edu.poc.demo.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    root.right.right = new TreeNode(11);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);
    ExecutionMeasure.measureExecutionTime(() -> System.out.println(pathSum(root, 8)));
  }

  static int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> prefixSumCount = new HashMap<>();
    // Initialize with 0 sum having one count to cover the case where the path sum equals targetSum
    // directly
    prefixSumCount.put(0L, 1);
    return dfs(root, 0L, targetSum, prefixSumCount);
  }

  private static int dfs(
      TreeNode node, long currentSum, long target, Map<Long, Integer> prefixSumCount) {
    if (node == null) {
      return 0;
    }

    // Update the current sum
    currentSum += node.val;

    // Get the number of valid paths that end at the current node
    int numPathsToCurrent = prefixSumCount.getOrDefault(currentSum - target, 0);

    // Update the map with the current sum, incrementing the count
    prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

    // Recurse to the left and right subtrees
    int result =
        numPathsToCurrent
            + dfs(node.left, currentSum, target, prefixSumCount)
            + dfs(node.right, currentSum, target, prefixSumCount);

    // After the recursion, decrement the count of the current sum
    prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

    return result;
  }
}
