package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2, new ListNode(0, new ListNode(9)));
    ListNode l2 = new ListNode(8, new ListNode(0, new ListNode(1)));
    ExecutionMeasure.measureExecutionTime(() -> addTwoNumbers(l1, l2));
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if (l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null) {
      return new ListNode(0);
    }

    return fillNodes(l1, l2, 0);
  }

  private static ListNode fillNodes(ListNode l1, ListNode l2, int add) {

    if (l1 != null || l2 != null) {

      if (l1 == null) {
        l1 = new ListNode();
      } else if (l2 == null) {
        l2 = new ListNode();
      }

      int overflow = (l1.val + l2.val + add) / 10;
      int nodeInteger = (add + l1.val + l2.val) % 10;
      return new ListNode(nodeInteger, fillNodes(l1.next, l2.next, overflow));

    } else if (add != 0) {
      return new ListNode(add, null);

    } else {
      return null;
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    public String toString() {
      return val + " -> " + next;
    }
  }
}
