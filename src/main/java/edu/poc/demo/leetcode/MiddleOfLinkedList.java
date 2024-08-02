package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 876. Middle of the Linked List
 *
 * <p>Given the head of a singly linked list, return the middle node of the linked list.
 *
 * <p>If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {

  public static void main(String[] args) {
    ListNode l1 =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ExecutionMeasure.measureExecutionTime(() -> middleNode(l1));
  }

  private static ListNode middleNode(ListNode head) {

    int totalNodes = 0;

    ListNode middle = head;
    int currentNode = 1;
    while (head != null) {
      totalNodes++;
      if (totalNodes / 2 >= currentNode) {
        middle = middle.next;
        currentNode++;
      }

      head = head.next;
    }
    return middle;
    
  }

  private static class ListNode {
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
