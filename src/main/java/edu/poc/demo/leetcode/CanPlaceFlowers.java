package edu.poc.demo.leetcode;

/**
 * 605. Can Place Flowers Solved Easy
 *
 * <p>You have a long flowerbed in which some of the plots are planted, and some are not. However,
 * flowers cannot be planted in adjacent plots.
 *
 * <p>Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not
 * empty, and an integer n, return true if n new flowers can be planted in the flowerbed without
 * violating the no-adjacent-flowers rule and false otherwise.
 *
 * <p>Example 1:
 *
 * <p>Input: flowerbed = [1,0,0,0,1], n = 1 Output: true Example 2:
 *
 * <p>Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= flowerbed.length <= 2 * 104 flowerbed[i] is 0 or 1. There are no two adjacent flowers in
 * flowerbed. 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers {
  private boolean canPlaceFlowers(int[] flowerbed, int n) {
    int size = flowerbed.length - 1;
    // iterate through flowerbed
    // if left and right is empty, add
    // if n is not empty afterwards, return false.

    if (flowerbed.length == 1) {
      if (flowerbed[0] == 0) n--;
      return n <= 0;
    }
    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      n--;
      flowerbed[0] = 1;
    }
    for (int i = 0; i < flowerbed.length; i++) {
      if (n <= 0) return true;
      int r = i + 2;
      int m = i + 1;

      if (m < flowerbed.length - 1 && flowerbed[m] == 0) {
        if (r < flowerbed.length && flowerbed[i] == 0 && flowerbed[r] == 0) {
          n--;
          flowerbed[m] = 1;
        }
      } else if (m == size && flowerbed[m] == 0) {
        if (flowerbed[i] == 0) {
          n--;
        }
      }
    }
    return n <= 0;
  }
}
