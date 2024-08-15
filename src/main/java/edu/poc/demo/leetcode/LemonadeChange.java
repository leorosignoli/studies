package edu.poc.demo.leetcode;

/**
 * 860. Lemonade Change Solved Easy
 *
 * <p>At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you
 * and order one at a time (in the order specified by bills). Each customer will only buy one
 * lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each
 * customer so that the net transaction is that the customer pays $5.
 *
 * <p>Note that you do not have any change in hand at first.
 *
 * <p>Given an integer array bills where bills[i] is the bill the ith customer pays, return true if
 * you can provide every customer with the correct change, or false otherwise.
 */
class LemonadeChange {

  private boolean lemonadeChange(int[] bills) {

    int totalMoney = 0;

    int tens = 0;
    int fives = 0;

    for (int bill : bills) {

      switch (bill) {
        case 5:
          fives++;
          break;
        case 10:
          if (fives > 0) {
            fives--;
            tens++;
          } else {
            // Can't provide change, return false
            return false;
          }
          break;
        case 20:
          if (tens > 0 && fives > 0) {
            tens--;
            fives--;
          } else if (fives >= 3) {
            fives -= 3;
          } else {
            return false;
          }
          break;
      }
    }
    return true;
  }
}
