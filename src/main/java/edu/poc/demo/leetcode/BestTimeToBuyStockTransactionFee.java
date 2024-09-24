package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class BestTimeToBuyStockTransactionFee {

    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime( () -> Solution.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
    class Solution {
        public static int maxProfit(int[] prices, int fee) {
            long cash = 0, hold = Integer.MIN_VALUE;

            for (int price : prices) {
                long prevCash = cash;
                cash = Math.max(cash, hold + price - fee);
                hold = Math.max(hold, prevCash - price);
            }

            return (int) cash;
        }
    }

}
