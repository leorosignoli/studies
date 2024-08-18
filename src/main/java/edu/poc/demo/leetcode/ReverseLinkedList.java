package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class ReverseLinkedList {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))));
  }

  public static ListNode reverseList(ListNode head) {
    return reverseListHelper(head, null);
  }

  private static ListNode reverseListHelper(ListNode current, ListNode prev) {
    // Base case: if the current node is null, return the previous node as the new head
    if (current == null) {
      return prev;
    }

    // Save the next node
    ListNode nextNode = current.next;

    // Reverse the link
    current.next = prev;

    // Tail recursive call
    return reverseListHelper(nextNode, current);
  }
}
