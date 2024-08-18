package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 134. Gas Station Solved Medium
 *
 * <p>Topics Companies There are n gas stations along a circular route, where the amount of gas at
 * the ith station is gas[i].
 *
 * <p>You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith
 * station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas
 * stations.
 *
 * <p>Given two integer arrays gas and cost, return the starting gas station's index if you can
 * travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a
 * solution, it is guaranteed to be unique
 *
 * <p>Example 1:
 *
 * <p>Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2] Output: 3 Explanation: Start at station 3 (index
 * 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4 Travel to station 4. Your tank = 4 - 1 +
 * 5 = 8 Travel to station 0. Your tank = 8 - 2 + 1 = 7 Travel to station 1. Your tank = 7 - 3 + 2 =
 * 6 Travel to station 2. Your tank = 6 - 4 + 3 = 5 Travel to station 3. The cost is 5. Your gas is
 * just enough to travel back to station 3. Therefore, return 3 as the starting index. Example 2:
 *
 * <p>Input: gas = [2,3,4], cost = [3,4,3] Output: -1 Explanation: You can't start at station 0 or
 * 1, as there is not enough gas to travel to the next station. Let's start at station 2 and fill up
 * with 4 unit of gas. Your tank = 0 + 4 = 4 Travel to station 0. Your tank = 4 - 3 + 2 = 3 Travel
 * to station 1. Your tank = 3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4
 * unit of gas but you only have 3. Therefore, you can't travel around the circuit once no matter
 * where you start.
 *
 * <p>Constraints:
 *
 * <p>n == gas.length == cost.length 1 <= n <= 105 0 <= gas[i], cost[i] <= 104
 */
public class GasStation {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
    ExecutionMeasure.measureExecutionTime(
        "kadane",
        () -> kadaneCanCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
  }

  static int canCompleteCircuit(int[] gas, int[] cost) {

    int totalCost = 0;
    int totalGas = 0;
    int startIndex = 0;
    int tank = 0;

    // Calculate total gas and total cost
    for (int i = 0; i < gas.length; i++) {
      totalGas += gas[i];
      totalCost += cost[i];
    }

    // If total gas is less than total cost, it's not possible to complete the circuit
    if (totalGas < totalCost) {
      return -1;
    }

    // Find the starting index
    for (int i = 0; i < gas.length; i++) {
      tank += gas[i] - cost[i];
      // If tank balance is negative, reset the start index to the next station
      if (tank < 0) {
        startIndex = i + 1 % gas.length;
        tank = 0;
      }
    }

    return startIndex;
  }

  static int kadaneCanCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    // Calculate the net gain at each station
    int[] net = new int[n];
    for (int i = 0; i < n; i++) {
      net[i] = gas[i] - cost[i];
    }

    // Use Kadane's Algorithm to find the maximum sum subarray
    int totalNet = 0;
    int currentSum = 0;
    int startIndex = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      totalNet += net[i];
      currentSum += net[i];

      if (currentSum > maxSum) {
        maxSum = currentSum;
        startIndex = i;
      }

      if (currentSum < 0) {
        currentSum = 0;
        startIndex = i + 1;
      }
    }

    // If total net gain is negative, it's impossible to complete the circuit
    if (totalNet < 0) {
      return -1;
    }

    // The start index found by Kadane's Algorithm may not always be correct
    // We need to verify if starting from this index allows completing the circuit
    int tank = 0;
    for (int i = 0; i < n; i++) {
      int idx = (startIndex + i) % n;
      tank += gas[idx] - cost[idx];
      if (tank < 0) {
        return -1;
      }
    }

    return startIndex % n;
  }
}
