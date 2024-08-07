package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 121. Best Time to Buy and Sell Stock Solved Easy
 *
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * <p>Example 1:
 *
 * <p>Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day
 * 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed
 * because you must buy before you sell. Example 2:
 *
 * <p>Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions are done and
 * the max profit = 0.
 */
public class BestTimeToBuyStock {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }

  private static int maxProfit(int[] prices) {

    // iterate through the array
    int maxPrice = -1;
    int currentPrice = Integer.MAX_VALUE;
    for (int price : prices) {

      // if the price is less then the current, it becomes the
      if (price < currentPrice) {
        currentPrice = price;
      }
      maxPrice = Math.max(maxPrice, price - currentPrice);
    }
    return maxPrice;
  }
}
