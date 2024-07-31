package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 141. Linked List Cycle
 *
 * <p>Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * <p>There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * <p>Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () ->
            hasCycle(
                new AddTwoNumbers.ListNode(
                    1,
                    new AddTwoNumbers.ListNode(
                        2,
                        new AddTwoNumbers.ListNode(
                            3, new AddTwoNumbers.ListNode(4, new AddTwoNumbers.ListNode(5)))))));
    System.out.println(5 / 2);
  }

  private static boolean hasCycle(AddTwoNumbers.ListNode head) {

    while (head != null) {

      if (head.val == Integer.MAX_VALUE) return true;

      head.val = Integer.MAX_VALUE;
      head = head.next;
    }
    return false;
  }
}
