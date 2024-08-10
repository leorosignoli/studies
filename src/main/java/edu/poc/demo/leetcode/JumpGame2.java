package edu.poc.demo.leetcode;

/**
 * 45. Jump Game II Solved Medium
 *
 * <p>You are given a 0-indexed array of integers nums of length n. You are initially positioned at
 * nums[0].
 *
 * <p>Each element nums[i] represents the maximum length of a forward jump from index i. In other
 * words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * <p>0 <= j <= nums[i] and i + j < n Return the minimum number of jumps to reach nums[n - 1]. The
 * test cases are generated such that you can reach nums[n - 1].
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to reach the last
 * index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index. Example 2:
 *
 * <p>Input: nums = [2,3,0,1,4] Output: 2
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 104 0 <= nums[i] <= 1000 It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGame2 {

  public static void main(String[] args) {
    System.out.println(new JumpGame2().jump(new int[] {2, 3, 1, 1, 4}));
    System.out.println(new JumpGame2().jump2(new int[] {2, 3, 0, 1, 4}));
  }

  public int jump(int[] nums) {

    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      // Update the farthest point we can reach from this position
      farthest = Math.max(farthest, i + nums[i]);

      // If we have reached the end of the current jump range
      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;

        // If the current end is beyond or at the last index, we can stop
        if (currentEnd >= nums.length - 1) {
          break;
        }
      }
    }

    return jumps;
  }

  public int jump2(int[] nums) {

    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      // Update the farthest point we can reach from this position
      farthest = Math.max(farthest, i + nums[i]);

      // If we have reached the end of the current jump range
      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;

        // If the current end is beyond or at the last index, we can stop
        if (currentEnd >= nums.length - 1) {
          break;
        }
      }
    }

    return jumps;
  }
}
