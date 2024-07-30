package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 20. Valid Parentheses Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Every close bracket has a corresponding open bracket of the same type.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "()" Output: true Example 2:
 *
 * <p>Input: s = "()[]{}" Output: true Example 3:
 *
 * <p>Input: s = "(]" Output: false
 */
public class ValidParentheses {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> isValid("()[]{}"));
  }

  private static boolean isValid(String s) {

    if (s.length() % 2 != 0) return false;

    LinkedList<Integer> linkedList = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i);

      switch (val) {
        case '(', '[', '{':
          linkedList.push(val);
          break;
        case 41:
          if (!Objects.equals(linkedList.peek(), 40)) return false;
          linkedList.poll();
          break;

        case 93:
          if (!Objects.equals(linkedList.peek(), 91)) return false;
          linkedList.poll();
          break;

        case 125:
          if (!Objects.equals(linkedList.peek(), 123)) return false;
          linkedList.poll();
          break;

        default:
      }
    }
    return linkedList.isEmpty();
  }
}
