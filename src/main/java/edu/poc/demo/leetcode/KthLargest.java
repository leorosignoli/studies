package edu.poc.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 703. Kth Largest Element in a Stream Solved Easy Design a class to find the kth largest element
 * in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct
 * element.
 *
 * <p>Implement KthLargest class:
 *
 * <p>KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of
 * integers nums. int add(int val) Appends the integer val to the stream and returns the element
 * representing the kth largest element in the stream.
 *
 * <p>Example 1:
 *
 * <p>Input ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]], [3], [5], [10],
 * [9], [4]] Output [null, 4, 5, 5, 8, 8]
 *
 * <p>Explanation KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]); kthLargest.add(3); //
 * return 4 kthLargest.add(5); // return 5 kthLargest.add(10); // return 5 kthLargest.add(9); //
 * return 8 kthLargest.add(4); // return 8
 */
class KthLargest {

  private List<Integer> nums;
  int k;

  public KthLargest(int k, int[] nums) {
    this.nums = new ArrayList<>(Arrays.stream(nums).boxed().toList());
    this.nums.sort(Comparator.naturalOrder());
    this.k = k;
  }

  public int add(int val) {
    nums.add(binarySearch(nums, val), val);

    return nums.get(nums.size() - k);
  }

  public static int binarySearch(List<Integer> ln, int x) {
    int l = 0;
    int h = ln.size();
    while (l < h) {
      int mid = (l + h) / 2;
      if (ln.get(mid) <= x) l = mid + 1;
      else h = mid;
    }
    return l;
  }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest obj = new
 * KthLargest(k, nums); int param_1 = obj.add(val);
 */
